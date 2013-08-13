package de.fxdiagram.core.tools.actions

import de.fxdiagram.core.XRootDiagram

import static de.fxdiagram.core.binding.NumberExpressionExtensions.*
import static java.lang.Math.*

import static extension de.fxdiagram.core.Extensions.*
import static extension de.fxdiagram.core.geometry.BoundsExtensions.*

class ZoomToFitAction implements DiagramAction {
	
	override perform(XRootDiagram diagram) {
		val selectionBounds = diagram.currentSelection.map[localToRootDiagram(snapBounds)].reduce[a,b|a+b]
		if(selectionBounds != null && selectionBounds.width > EPSILON && selectionBounds.height > EPSILON) {
			val targetScale =  
					min(diagram.scene.width / selectionBounds.width, 
						diagram.scene.height / selectionBounds.height)
			new ScrollToAndScaleTransition(diagram, selectionBounds.center, targetScale).play
		}
	}
}