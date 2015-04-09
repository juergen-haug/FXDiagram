package de.fxdiagram.core.behavior

import de.fxdiagram.core.XConnection
import de.fxdiagram.core.XControlPoint
import java.util.List
import javafx.collections.ObservableList
import javafx.geometry.Point2D

import static de.fxdiagram.core.XControlPoint.Type.*
import static de.fxdiagram.core.extensions.NumberExpressionExtensions.*
import static de.fxdiagram.core.extensions.Point2DExtensions.*

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import javafx.scene.input.MouseEvent
import java.util.Map
import com.google.common.collect.Maps
import de.fxdiagram.core.command.ParallelAnimationCommand
import de.fxdiagram.core.command.MoveCommand

class ControlPointMoveBehavior extends MoveBehavior<XControlPoint> {

	new(XControlPoint host) {
		super(host)
	}

	override protected dragTo(Point2D newPositionInDiagram) {
		if(newPositionInDiagram != null) {
			val moveDeltaX = newPositionInDiagram.x - host.layoutX			
			val moveDeltaY = newPositionInDiagram.y - host.layoutY
			super.dragTo(newPositionInDiagram)
			val siblings = getSiblings
			val index = siblings.indexOf(host)
			if (host.type == INTERPOLATED) {
				adjustBoth(index, siblings, moveDeltaX, moveDeltaY)
			} else if (host.type == CONTROL_POINT) {
				adjustLeft(index, siblings, moveDeltaX, moveDeltaY)
				adjustRight(index, siblings, moveDeltaX, moveDeltaY)
			}
		} 
	}
	
	protected def adjustBoth(int index, ObservableList<XControlPoint> siblings,
							 double moveDeltaX, double moveDeltaY) {
		if (index > 0 && index < siblings.size - 1) {
			val predecessor = siblings.get(index - 1)
			val successor = siblings.get(index + 1)
			if (predecessor.type == CONTROL_POINT && successor.type == CONTROL_POINT) {
				val dx0 = successor.layoutX - predecessor.layoutX
				val dy0 = successor.layoutY - predecessor.layoutY
				val dx1 = host.layoutX - predecessor.layoutX
				val dy1 = host.layoutY - predecessor.layoutY
				val normProd = norm(dx0, dy0) * norm(dx1, dy1)
				if (normProd > EPSILON * EPSILON) {
					val scalarProd = 0.5 * (dx0 * dx1 + dy0 * dy1) / normProd
					val orthoX = dx1 - scalarProd * dx0
					val orthoY = dy1 - scalarProd * dy0
					if (norm(orthoX, orthoY) > EPSILON) {
						if(!predecessor.selected) {
							predecessor.layoutX = predecessor.layoutX + orthoX
							predecessor.layoutY = predecessor.layoutY + orthoY
							adjustLeft(index - 1, siblings, moveDeltaX, moveDeltaY)
						}
						if(!successor.selected) {
							successor.layoutX = successor.layoutX + orthoX
							successor.layoutY = successor.layoutY + orthoY
							adjustRight(index + 1, siblings, moveDeltaX, moveDeltaY)
						}
					}
				}
			}
		}
	}

	protected def void adjustLeft(int index, List<XControlPoint> siblings, 
								  double moveDeltaX, double moveDeltaY) {
		if (index > 1) {
			val current = siblings.get(index)
			val predecessor = siblings.get(index - 1)
			val prepredecessor = siblings.get(index - 2)
			if (predecessor.type == INTERPOLATED && prepredecessor.type == CONTROL_POINT) {
				if(!prepredecessor.selected) {
					val dx0 = predecessor.layoutX - current.layoutX
					val dy0 = predecessor.layoutY - current.layoutY
					val norm0 = norm(dx0, dy0)
					if(norm0 > EPSILON) {
						val dx1 = prepredecessor.layoutX - predecessor.layoutX
						val dy1 = prepredecessor.layoutY - predecessor.layoutY
						val scale = norm(dx1, dy1) / norm0
						prepredecessor.layoutX = predecessor.layoutX + scale * dx0
						prepredecessor.layoutY = predecessor.layoutY + scale * dy0
					} 
					adjustLeft(index-2, siblings, moveDeltaX, moveDeltaY)
				} else if(!predecessor.selected) {
					predecessor.layoutX = predecessor.layoutX + 0.5 * moveDeltaX
					predecessor.layoutY = predecessor.layoutY + 0.5 * moveDeltaY
				}
			}
		}
	}

	protected def void adjustRight(int index, List<XControlPoint> siblings, 
								   double moveDeltaX, double moveDeltaY) {
		if (index < siblings.size - 2) {
			val current = siblings.get(index)
			val successor = siblings.get(index + 1)
			val postsuccessor = siblings.get(index + 2)
			if (successor.type == INTERPOLATED && postsuccessor.type == CONTROL_POINT) {
				if(!postsuccessor.selected) {
					val dx0 = successor.layoutX - current.layoutX
					val dy0 = successor.layoutY - current.layoutY
					val norm0 = norm(dx0, dy0)
					if(norm0 > EPSILON) {
						val dx1 = postsuccessor.layoutX - successor.layoutX
						val dy1 = postsuccessor.layoutY - successor.layoutY
						val scale = norm(dx1, dy1) / norm0
						postsuccessor.layoutX = successor.layoutX + scale * dx0
						postsuccessor.layoutY = successor.layoutY + scale * dy0
					} 
					adjustRight(index+2, siblings, moveDeltaX, moveDeltaY)
				} else if(!successor.selected) {
					successor.layoutX = successor.layoutX + 0.5 * moveDeltaX
					successor.layoutY = successor.layoutY + 0.5 * moveDeltaY
				}
			}
		}
	}

	protected def getSiblings() {
		val connection = host.parent?.containerShape
		if (connection instanceof XConnection)
			connection.controlPoints
		else
			null
	}
	
	Map<XControlPoint, Point2D> initialPositions
	
	override mousePressed(MouseEvent it) {
		super.mousePressed(it)
		initialPositions = Maps.toMap(siblings, [new Point2D(layoutX, layoutY)])
	}
	
	override protected createMoveCommand() {
		val pac = new ParallelAnimationCommand 
		initialPositions.entrySet.forEach [
			if(key.layoutX != value.x || key.layoutY != value.y)
				pac += new MoveCommand(key, value.x, value.y, key.layoutX, key.layoutY)
		] 
		pac
	}
}