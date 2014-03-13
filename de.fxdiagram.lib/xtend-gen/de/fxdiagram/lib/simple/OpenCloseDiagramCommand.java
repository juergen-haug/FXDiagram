package de.fxdiagram.lib.simple;

import com.google.common.base.Objects;
import de.fxdiagram.annotations.logging.Logging;
import de.fxdiagram.core.HeadsUpDisplay;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.behavior.AbstractCloseBehavior;
import de.fxdiagram.core.command.AbstractAnimationCommand;
import de.fxdiagram.core.command.CommandContext;
import de.fxdiagram.core.command.CommandStack;
import de.fxdiagram.core.extensions.AccumulativeTransform2D;
import de.fxdiagram.core.extensions.BoundsExtensions;
import de.fxdiagram.core.extensions.CoreExtensions;
import de.fxdiagram.core.extensions.DurationExtensions;
import de.fxdiagram.core.extensions.TooltipExtensions;
import de.fxdiagram.core.tools.actions.ScrollToAndScaleTransition;
import de.fxdiagram.lib.nodes.RectangleBorderPane;
import de.fxdiagram.lib.simple.DiagramScaler;
import de.fxdiagram.lib.simple.OpenDiagramParameters;
import de.fxdiagram.lib.simple.OpenableDiagramNode;
import eu.hansolo.enzo.radialmenu.Symbol;
import eu.hansolo.enzo.radialmenu.SymbolCanvas;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Logging
@SuppressWarnings("all")
public class OpenCloseDiagramCommand extends AbstractAnimationCommand {
  private double delayFactor = 0.1;
  
  private boolean isOpenCommand;
  
  @Extension
  private OpenDiagramParameters params;
  
  public static OpenCloseDiagramCommand newOpenCommand(final OpenableDiagramNode node) {
    OpenDiagramParameters _calculateParams = OpenCloseDiagramCommand.calculateParams(node);
    return new OpenCloseDiagramCommand(true, _calculateParams);
  }
  
  public static OpenCloseDiagramCommand newCloseCommand(final XRoot root, final OpenDiagramParameters params) {
    return new OpenCloseDiagramCommand(false, params);
  }
  
  protected OpenCloseDiagramCommand(final boolean isOpenCommand, final OpenDiagramParameters params) {
    this.isOpenCommand = isOpenCommand;
    this.params = params;
  }
  
  protected static OpenDiagramParameters calculateParams(final OpenableDiagramNode host) {
    OpenDiagramParameters _xblockexpression = null;
    {
      Bounds _layoutBounds = host.getLayoutBounds();
      Insets _insets = new Insets(5, 5, 5, 5);
      final BoundingBox nodeBounds = BoundsExtensions.operator_minus(_layoutBounds, _insets);
      Point2D _center = BoundsExtensions.center(nodeBounds);
      final Point2D nodeCenterInDiagram = CoreExtensions.localToRootDiagram(host, _center);
      XDiagram _innerDiagram = host.getInnerDiagram();
      DiagramScaler _diagramScaler = new DiagramScaler(_innerDiagram);
      final Procedure1<DiagramScaler> _function = new Procedure1<DiagramScaler>() {
        public void apply(final DiagramScaler it) {
          double _width = nodeBounds.getWidth();
          it.setWidth(_width);
          double _height = nodeBounds.getHeight();
          it.setHeight(_height);
        }
      };
      final DiagramScaler diagramScaler = ObjectExtensions.<DiagramScaler>operator_doubleArrow(_diagramScaler, _function);
      XRoot _root = CoreExtensions.getRoot(host);
      _xblockexpression = new OpenDiagramParameters(host, _root, diagramScaler, nodeCenterInDiagram);
    }
    return _xblockexpression;
  }
  
  protected ParallelTransition openDiagram(final Duration duration) {
    ParallelTransition _xblockexpression = null;
    {
      OpenableDiagramNode _host = this.params.getHost();
      XDiagram _innerDiagram = _host.getInnerDiagram();
      _innerDiagram.setOpacity(0);
      OpenableDiagramNode _host_1 = this.params.getHost();
      RectangleBorderPane _pane = _host_1.getPane();
      ObservableList<Node> _children = _pane.getChildren();
      Group _group = new Group();
      final Procedure1<Group> _function = new Procedure1<Group>() {
        public void apply(final Group it) {
          ObservableList<Node> _children = it.getChildren();
          OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
          XDiagram _innerDiagram = _host.getInnerDiagram();
          _children.add(_innerDiagram);
        }
      };
      Group _doubleArrow = ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
      _children.add(_doubleArrow);
      OpenableDiagramNode _host_2 = this.params.getHost();
      XDiagram _innerDiagram_1 = _host_2.getInnerDiagram();
      _innerDiagram_1.activate();
      final AbstractCloseBehavior _function_1 = new AbstractCloseBehavior() {
        public void close() {
          XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
          CommandStack _commandStack = _root.getCommandStack();
          XRoot _root_1 = OpenCloseDiagramCommand.this.params.getRoot();
          OpenCloseDiagramCommand _newCloseCommand = OpenCloseDiagramCommand.newCloseCommand(_root_1, OpenCloseDiagramCommand.this.params);
          _commandStack.execute(_newCloseCommand);
        }
      };
      final AbstractCloseBehavior closeBehavior = _function_1;
      OpenableDiagramNode _host_3 = this.params.getHost();
      XDiagram _innerDiagram_2 = _host_3.getInnerDiagram();
      _innerDiagram_2.addBehavior(closeBehavior);
      OpenableDiagramNode _host_4 = this.params.getHost();
      XDiagram _innerDiagram_3 = _host_4.getInnerDiagram();
      _innerDiagram_3.layout();
      DiagramScaler _diagramScaler = this.params.getDiagramScaler();
      _diagramScaler.activate();
      OpenableDiagramNode _host_5 = this.params.getHost();
      XDiagram _innerDiagram_4 = _host_5.getInnerDiagram();
      BoundingBox _boundingBox = new BoundingBox(0, 0, 1, 0);
      Bounds _localToScene = _innerDiagram_4.localToScene(_boundingBox);
      final double initialScale = _localToScene.getWidth();
      OpenableDiagramNode _host_6 = this.params.getHost();
      XDiagram _innerDiagram_5 = _host_6.getInnerDiagram();
      final Bounds diagramBoundsInLocal = _innerDiagram_5.getBoundsInLocal();
      XRoot _root = this.params.getRoot();
      Scene _scene = _root.getScene();
      double _width = _scene.getWidth();
      double _width_1 = diagramBoundsInLocal.getWidth();
      double _divide = (_width / _width_1);
      XRoot _root_1 = this.params.getRoot();
      Scene _scene_1 = _root_1.getScene();
      double _height = _scene_1.getHeight();
      double _height_1 = diagramBoundsInLocal.getHeight();
      double _divide_1 = (_height / _height_1);
      double _min = Math.min(_divide, _divide_1);
      double _min_1 = Math.min(1, _min);
      double _divide_2 = (_min_1 / initialScale);
      double _max = Math.max(AccumulativeTransform2D.MIN_SCALE, _divide_2);
      XRoot _root_2 = this.params.getRoot();
      AccumulativeTransform2D _diagramTransform = _root_2.getDiagramTransform();
      double _scale = _diagramTransform.getScale();
      final double targetScale = (_max * _scale);
      ParallelTransition _parallelTransition = new ParallelTransition();
      final Procedure1<ParallelTransition> _function_2 = new Procedure1<ParallelTransition>() {
        public void apply(final ParallelTransition it) {
          ObservableList<Animation> _children = it.getChildren();
          XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
          Point2D _nodeCenterInDiagram = OpenCloseDiagramCommand.this.params.getNodeCenterInDiagram();
          ScrollToAndScaleTransition _scrollToAndScaleTransition = new ScrollToAndScaleTransition(_root, _nodeCenterInDiagram, targetScale);
          final Procedure1<ScrollToAndScaleTransition> _function = new Procedure1<ScrollToAndScaleTransition>() {
            public void apply(final ScrollToAndScaleTransition it) {
              it.setDuration(duration);
              final EventHandler<ActionEvent> _function = new EventHandler<ActionEvent>() {
                public void handle(final ActionEvent it) {
                  DiagramScaler _diagramScaler = OpenCloseDiagramCommand.this.params.getDiagramScaler();
                  _diagramScaler.deactivate();
                  OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
                  XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
                  XDiagram _diagram = _root.getDiagram();
                  _host.setParentDiagram(_diagram);
                  OpenableDiagramNode _host_1 = OpenCloseDiagramCommand.this.params.getHost();
                  RectangleBorderPane _pane = _host_1.getPane();
                  ObservableList<Node> _children = _pane.getChildren();
                  OpenableDiagramNode _host_2 = OpenCloseDiagramCommand.this.params.getHost();
                  Text _textNode = _host_2.getTextNode();
                  _children.setAll(_textNode);
                  Canvas _symbol = SymbolCanvas.getSymbol(Symbol.Type.ZOOM_OUT, 32, Color.GRAY);
                  final Procedure1<Canvas> _function = new Procedure1<Canvas>() {
                    public void apply(final Canvas it) {
                      final EventHandler<MouseEvent> _function = new EventHandler<MouseEvent>() {
                        public void handle(final MouseEvent it) {
                          XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
                          HeadsUpDisplay _headsUpDisplay = _root.getHeadsUpDisplay();
                          ObservableList<Node> _children = _headsUpDisplay.getChildren();
                          EventTarget _target = it.getTarget();
                          _children.remove(((Node) _target));
                          XRoot _root_1 = OpenCloseDiagramCommand.this.params.getRoot();
                          CommandStack _commandStack = _root_1.getCommandStack();
                          XRoot _root_2 = OpenCloseDiagramCommand.this.params.getRoot();
                          OpenCloseDiagramCommand _newCloseCommand = OpenCloseDiagramCommand.newCloseCommand(_root_2, OpenCloseDiagramCommand.this.params);
                          _commandStack.execute(_newCloseCommand);
                        }
                      };
                      it.setOnMouseClicked(_function);
                      TooltipExtensions.setTooltip(it, "Parent diagram");
                    }
                  };
                  final Canvas toParentButton = ObjectExtensions.<Canvas>operator_doubleArrow(_symbol, _function);
                  OpenableDiagramNode _host_3 = OpenCloseDiagramCommand.this.params.getHost();
                  XDiagram _innerDiagram = _host_3.getInnerDiagram();
                  ObservableMap<Node,Pos> _fixedButtons = _innerDiagram.getFixedButtons();
                  _fixedButtons.put(toParentButton, Pos.TOP_RIGHT);
                  XRoot _root_1 = OpenCloseDiagramCommand.this.params.getRoot();
                  OpenableDiagramNode _host_4 = OpenCloseDiagramCommand.this.params.getHost();
                  XDiagram _innerDiagram_1 = _host_4.getInnerDiagram();
                  _root_1.setDiagram(_innerDiagram_1);
                }
              };
              it.setOnFinished(_function);
            }
          };
          ScrollToAndScaleTransition _doubleArrow = ObjectExtensions.<ScrollToAndScaleTransition>operator_doubleArrow(_scrollToAndScaleTransition, _function);
          _children.add(_doubleArrow);
          ObservableList<Animation> _children_1 = it.getChildren();
          FadeTransition _fadeTransition = new FadeTransition();
          final Procedure1<FadeTransition> _function_1 = new Procedure1<FadeTransition>() {
            public void apply(final FadeTransition it) {
              Duration _multiply = DurationExtensions.operator_multiply((1 - OpenCloseDiagramCommand.this.delayFactor), duration);
              it.setDuration(_multiply);
              it.setFromValue(1);
              it.setToValue(0);
              OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
              Text _textNode = _host.getTextNode();
              it.setNode(_textNode);
            }
          };
          FadeTransition _doubleArrow_1 = ObjectExtensions.<FadeTransition>operator_doubleArrow(_fadeTransition, _function_1);
          _children_1.add(_doubleArrow_1);
          ObservableList<Animation> _children_2 = it.getChildren();
          FadeTransition _fadeTransition_1 = new FadeTransition();
          final Procedure1<FadeTransition> _function_2 = new Procedure1<FadeTransition>() {
            public void apply(final FadeTransition it) {
              Duration _multiply = DurationExtensions.operator_multiply(OpenCloseDiagramCommand.this.delayFactor, duration);
              it.setDelay(_multiply);
              Duration _multiply_1 = DurationExtensions.operator_multiply((1 - OpenCloseDiagramCommand.this.delayFactor), duration);
              it.setDuration(_multiply_1);
              it.setFromValue(0);
              it.setToValue(1);
              OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
              XDiagram _innerDiagram = _host.getInnerDiagram();
              it.setNode(_innerDiagram);
            }
          };
          FadeTransition _doubleArrow_2 = ObjectExtensions.<FadeTransition>operator_doubleArrow(_fadeTransition_1, _function_2);
          _children_2.add(_doubleArrow_2);
        }
      };
      _xblockexpression = ObjectExtensions.<ParallelTransition>operator_doubleArrow(_parallelTransition, _function_2);
    }
    return _xblockexpression;
  }
  
  protected ParallelTransition closeDiagram(final Duration duration) {
    ParallelTransition _xblockexpression = null;
    {
      XRoot _root = this.params.getRoot();
      OpenableDiagramNode _host = this.params.getHost();
      XDiagram _parentDiagram = _host.getParentDiagram();
      _root.setDiagram(_parentDiagram);
      OpenableDiagramNode _host_1 = this.params.getHost();
      RectangleBorderPane _pane = _host_1.getPane();
      ObservableList<Node> _children = _pane.getChildren();
      Group _group = new Group();
      final Procedure1<Group> _function = new Procedure1<Group>() {
        public void apply(final Group it) {
          ObservableList<Node> _children = it.getChildren();
          OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
          XDiagram _innerDiagram = _host.getInnerDiagram();
          _children.add(_innerDiagram);
        }
      };
      Group _doubleArrow = ObjectExtensions.<Group>operator_doubleArrow(_group, _function);
      _children.add(_doubleArrow);
      OpenableDiagramNode _host_2 = this.params.getHost();
      XDiagram _innerDiagram = _host_2.getInnerDiagram();
      _innerDiagram.activate();
      OpenableDiagramNode _host_3 = this.params.getHost();
      XDiagram _innerDiagram_1 = _host_3.getInnerDiagram();
      _innerDiagram_1.layout();
      DiagramScaler _diagramScaler = this.params.getDiagramScaler();
      _diagramScaler.activate();
      ParallelTransition _parallelTransition = new ParallelTransition();
      final Procedure1<ParallelTransition> _function_1 = new Procedure1<ParallelTransition>() {
        public void apply(final ParallelTransition it) {
          ObservableList<Animation> _children = it.getChildren();
          XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
          Point2D _nodeCenterInDiagram = OpenCloseDiagramCommand.this.params.getNodeCenterInDiagram();
          ScrollToAndScaleTransition _scrollToAndScaleTransition = new ScrollToAndScaleTransition(_root, _nodeCenterInDiagram, 1);
          final Procedure1<ScrollToAndScaleTransition> _function = new Procedure1<ScrollToAndScaleTransition>() {
            public void apply(final ScrollToAndScaleTransition it) {
              it.setDuration(duration);
              final EventHandler<ActionEvent> _function = new EventHandler<ActionEvent>() {
                public void handle(final ActionEvent it) {
                  DiagramScaler _diagramScaler = OpenCloseDiagramCommand.this.params.getDiagramScaler();
                  _diagramScaler.deactivate();
                  OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
                  XRoot _root = OpenCloseDiagramCommand.this.params.getRoot();
                  XDiagram _diagram = _root.getDiagram();
                  _host.setParentDiagram(_diagram);
                  OpenableDiagramNode _host_1 = OpenCloseDiagramCommand.this.params.getHost();
                  RectangleBorderPane _pane = _host_1.getPane();
                  ObservableList<Node> _children = _pane.getChildren();
                  OpenableDiagramNode _host_2 = OpenCloseDiagramCommand.this.params.getHost();
                  Text _textNode = _host_2.getTextNode();
                  _children.setAll(_textNode);
                }
              };
              it.setOnFinished(_function);
            }
          };
          ScrollToAndScaleTransition _doubleArrow = ObjectExtensions.<ScrollToAndScaleTransition>operator_doubleArrow(_scrollToAndScaleTransition, _function);
          _children.add(_doubleArrow);
          ObservableList<Animation> _children_1 = it.getChildren();
          FadeTransition _fadeTransition = new FadeTransition();
          final Procedure1<FadeTransition> _function_1 = new Procedure1<FadeTransition>() {
            public void apply(final FadeTransition it) {
              Duration _multiply = DurationExtensions.operator_multiply(OpenCloseDiagramCommand.this.delayFactor, duration);
              it.setDelay(_multiply);
              Duration _multiply_1 = DurationExtensions.operator_multiply((1 - OpenCloseDiagramCommand.this.delayFactor), duration);
              it.setDuration(_multiply_1);
              it.setFromValue(0);
              it.setToValue(1);
              OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
              Text _textNode = _host.getTextNode();
              it.setNode(_textNode);
            }
          };
          FadeTransition _doubleArrow_1 = ObjectExtensions.<FadeTransition>operator_doubleArrow(_fadeTransition, _function_1);
          _children_1.add(_doubleArrow_1);
          ObservableList<Animation> _children_2 = it.getChildren();
          FadeTransition _fadeTransition_1 = new FadeTransition();
          final Procedure1<FadeTransition> _function_2 = new Procedure1<FadeTransition>() {
            public void apply(final FadeTransition it) {
              Duration _multiply = DurationExtensions.operator_multiply((1 - OpenCloseDiagramCommand.this.delayFactor), duration);
              it.setDuration(_multiply);
              it.setFromValue(1);
              it.setToValue(0);
              OpenableDiagramNode _host = OpenCloseDiagramCommand.this.params.getHost();
              XDiagram _innerDiagram = _host.getInnerDiagram();
              it.setNode(_innerDiagram);
            }
          };
          FadeTransition _doubleArrow_2 = ObjectExtensions.<FadeTransition>operator_doubleArrow(_fadeTransition_1, _function_2);
          _children_2.add(_doubleArrow_2);
        }
      };
      _xblockexpression = ObjectExtensions.<ParallelTransition>operator_doubleArrow(_parallelTransition, _function_1);
    }
    return _xblockexpression;
  }
  
  public Animation createExecuteAnimation(final CommandContext context) {
    ParallelTransition _xifexpression = null;
    if (this.isOpenCommand) {
      Duration _defaultExecuteDuration = context.getDefaultExecuteDuration();
      _xifexpression = this.openDiagram(_defaultExecuteDuration);
    } else {
      Duration _defaultExecuteDuration_1 = context.getDefaultExecuteDuration();
      _xifexpression = this.closeDiagram(_defaultExecuteDuration_1);
    }
    return _xifexpression;
  }
  
  public Animation createUndoAnimation(final CommandContext context) {
    ParallelTransition _xifexpression = null;
    if (this.isOpenCommand) {
      Duration _defaultUndoDuration = context.getDefaultUndoDuration();
      _xifexpression = this.closeDiagram(_defaultUndoDuration);
    } else {
      Duration _defaultUndoDuration_1 = context.getDefaultUndoDuration();
      _xifexpression = this.openDiagram(_defaultUndoDuration_1);
    }
    return _xifexpression;
  }
  
  public Animation createRedoAnimation(final CommandContext context) {
    ParallelTransition _xifexpression = null;
    if (this.isOpenCommand) {
      Duration _defaultUndoDuration = context.getDefaultUndoDuration();
      _xifexpression = this.openDiagram(_defaultUndoDuration);
    } else {
      Duration _defaultUndoDuration_1 = context.getDefaultUndoDuration();
      _xifexpression = this.closeDiagram(_defaultUndoDuration_1);
    }
    return _xifexpression;
  }
  
  protected boolean isDiagramOpen() {
    XRoot _root = this.params.getRoot();
    XDiagram _diagram = _root.getDiagram();
    OpenableDiagramNode _host = this.params.getHost();
    XDiagram _innerDiagram = _host.getInnerDiagram();
    return Objects.equal(_diagram, _innerDiagram);
  }
  
  private static Logger LOG = Logger.getLogger("de.fxdiagram.lib.simple.OpenCloseDiagramCommand");
    ;
}