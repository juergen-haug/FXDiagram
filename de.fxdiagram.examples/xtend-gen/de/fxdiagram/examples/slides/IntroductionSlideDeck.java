package de.fxdiagram.examples.slides;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.fxdiagram.core.extensions.DurationExtensions;
import de.fxdiagram.core.extensions.UriExtensions;
import de.fxdiagram.core.services.ImageCache;
import de.fxdiagram.examples.slides.ClickThroughSlide;
import de.fxdiagram.examples.slides.Slide;
import de.fxdiagram.examples.slides.SlideDiagram;
import de.fxdiagram.examples.slides.Styles;
import de.fxdiagram.lib.simple.OpenableDiagramNode;
import java.util.Collections;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IntroductionSlideDeck extends OpenableDiagramNode {
  public IntroductionSlideDeck() {
    super("Introduction");
    SlideDiagram _slideDiagram = new SlideDiagram();
    final Procedure1<SlideDiagram> _function = new Procedure1<SlideDiagram>() {
      public void apply(final SlideDiagram it) {
        List<Slide> _slides = it.getSlides();
        Slide _slide = new Slide("Title");
        final Procedure1<Slide> _function = new Procedure1<Slide>() {
          public void apply(final Slide it) {
            StackPane _stackPane = it.getStackPane();
            final Procedure1<StackPane> _function = new Procedure1<StackPane>() {
              public void apply(final StackPane it) {
                ObservableList<Node> _children = it.getChildren();
                Pane _pane = new Pane();
                final Procedure1<Pane> _function = new Procedure1<Pane>() {
                  public void apply(final Pane it) {
                    it.setPrefSize(1024, 768);
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("GEF", 22);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(340);
                        it.setLayoutX(110);
                        it.setLayoutY(379);
                        Styles.breathe(it);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Text _createJungleText_1 = Styles.createJungleText("Draw2D", 22);
                    final Procedure1<Text> _function_1 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(339);
                        it.setLayoutX(405);
                        it.setLayoutY(147);
                        Styles.flicker(it);
                      }
                    };
                    Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_1, _function_1);
                    _children_1.add(_doubleArrow_1);
                    ObservableList<Node> _children_2 = it.getChildren();
                    Text _createJungleText_2 = Styles.createJungleText("GMF RT", 22);
                    final Procedure1<Text> _function_2 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setLayoutX(762);
                        it.setLayoutY(61);
                        Styles.dangle(it);
                      }
                    };
                    Text _doubleArrow_2 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_2, _function_2);
                    _children_2.add(_doubleArrow_2);
                    ObservableList<Node> _children_3 = it.getChildren();
                    Text _createJungleText_3 = Styles.createJungleText("Graphiti", 22);
                    final Procedure1<Text> _function_3 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(11);
                        it.setLayoutX(850);
                        it.setLayoutY(349);
                        Styles.breathe(it);
                      }
                    };
                    Text _doubleArrow_3 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_3, _function_3);
                    _children_3.add(_doubleArrow_3);
                    ObservableList<Node> _children_4 = it.getChildren();
                    Text _createJungleText_4 = Styles.createJungleText("Sirius", 22);
                    final Procedure1<Text> _function_4 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(67);
                        it.setLayoutX(188);
                        it.setLayoutY(229);
                        Styles.flicker(it);
                      }
                    };
                    Text _doubleArrow_4 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_4, _function_4);
                    _children_4.add(_doubleArrow_4);
                    ObservableList<Node> _children_5 = it.getChildren();
                    Text _createJungleText_5 = Styles.createJungleText("GMF Tooling", 22);
                    final Procedure1<Text> _function_5 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setLayoutX(595);
                        it.setLayoutY(121);
                        Styles.dangle(it);
                      }
                    };
                    Text _doubleArrow_5 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_5, _function_5);
                    _children_5.add(_doubleArrow_5);
                  }
                };
                Pane _doubleArrow = ObjectExtensions.<Pane>operator_doubleArrow(_pane, _function);
                _children.add(_doubleArrow);
                ObservableList<Node> _children_1 = it.getChildren();
                VBox _vBox = new VBox();
                final Procedure1<VBox> _function_1 = new Procedure1<VBox>() {
                  public void apply(final VBox it) {
                    it.setAlignment(Pos.CENTER);
                    Insets _insets = new Insets(400, 0, 0, 0);
                    StackPane.setMargin(it, _insets);
                    ObservableList<Node> _children = it.getChildren();
                    Text _createText = Styles.createText("Eclipse Diagram Editors", 93);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _rgb = Color.rgb(238, 191, 171);
                        it.setFill(_rgb);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Text _createText_1 = Styles.createText("An Endangered Species", 48);
                    final Procedure1<Text> _function_1 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                      }
                    };
                    Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(_createText_1, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                VBox _doubleArrow_1 = ObjectExtensions.<VBox>operator_doubleArrow(_vBox, _function_1);
                _children_1.add(_doubleArrow_1);
              }
            };
            ObjectExtensions.<StackPane>operator_doubleArrow(_stackPane, _function);
          }
        };
        Slide _doubleArrow = ObjectExtensions.<Slide>operator_doubleArrow(_slide, _function);
        _slides.add(_doubleArrow);
        List<Slide> _slides_1 = it.getSlides();
        Slide _slide_1 = new Slide("The Eclipse Jungle", 110);
        _slides_1.add(_slide_1);
        List<Slide> _slides_2 = it.getSlides();
        Slide _slide_2 = new Slide("Jungle images");
        final Procedure1<Slide> _function_1 = new Procedure1<Slide>() {
          public void apply(final Slide it) {
            StackPane _stackPane = it.getStackPane();
            final Procedure1<StackPane> _function = new Procedure1<StackPane>() {
              public void apply(final StackPane it) {
                ObservableList<Node> _children = it.getChildren();
                Pane _pane = new Pane();
                final Procedure1<Pane> _function = new Procedure1<Pane>() {
                  public void apply(final Pane it) {
                    it.setPrefSize(1024, 768);
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("GEF", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(16);
                        it.setLayoutX(80);
                        it.setLayoutY(665);
                        Styles.flicker(it);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Text _createJungleText_1 = Styles.createJungleText("Draw2D", 48);
                    final Procedure1<Text> _function_1 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(338);
                        it.setLayoutX(380);
                        it.setLayoutY(132);
                        Styles.crawl(it);
                      }
                    };
                    Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_1, _function_1);
                    _children_1.add(_doubleArrow_1);
                    ObservableList<Node> _children_2 = it.getChildren();
                    Text _createJungleText_2 = Styles.createJungleText("GMF RT", 48);
                    final Procedure1<Text> _function_2 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(10);
                        it.setLayoutX(560);
                        it.setLayoutY(300);
                        Styles.crawl(it);
                      }
                    };
                    Text _doubleArrow_2 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_2, _function_2);
                    _children_2.add(_doubleArrow_2);
                    ObservableList<Node> _children_3 = it.getChildren();
                    Text _createJungleText_3 = Styles.createJungleText("Graphiti", 48);
                    final Procedure1<Text> _function_3 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(332);
                        it.setLayoutX(710);
                        it.setLayoutY(630);
                        Styles.breathe(it);
                      }
                    };
                    Text _doubleArrow_3 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_3, _function_3);
                    _children_3.add(_doubleArrow_3);
                    ObservableList<Node> _children_4 = it.getChildren();
                    Text _createJungleText_4 = Styles.createJungleText("Sirius", 48);
                    final Procedure1<Text> _function_4 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setLayoutX(111);
                        it.setLayoutY(167);
                        Styles.dangle(it);
                      }
                    };
                    Text _doubleArrow_4 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_4, _function_4);
                    _children_4.add(_doubleArrow_4);
                    ObservableList<Node> _children_5 = it.getChildren();
                    Text _createJungleText_5 = Styles.createJungleText("GMF Tools", 48);
                    final Procedure1<Text> _function_5 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _jungleDarkGreen = Styles.jungleDarkGreen();
                        it.setFill(_jungleDarkGreen);
                        it.setRotate(5);
                        it.setLayoutX(190);
                        it.setLayoutY(480);
                        Styles.breathe(it);
                      }
                    };
                    Text _doubleArrow_5 = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText_5, _function_5);
                    _children_5.add(_doubleArrow_5);
                  }
                };
                Pane _doubleArrow = ObjectExtensions.<Pane>operator_doubleArrow(_pane, _function);
                _children.add(_doubleArrow);
              }
            };
            ObjectExtensions.<StackPane>operator_doubleArrow(_stackPane, _function);
          }
        };
        Slide _doubleArrow_1 = ObjectExtensions.<Slide>operator_doubleArrow(_slide_2, _function_1);
        _slides_2.add(_doubleArrow_1);
        List<Slide> _slides_3 = it.getSlides();
        Slide _slide_3 = new Slide("Darkness", 144);
        _slides_3.add(_slide_3);
        List<Slide> _slides_4 = it.getSlides();
        ClickThroughSlide _clickThroughSlide = new ClickThroughSlide("Darkness images");
        final Procedure1<ClickThroughSlide> _function_2 = new Procedure1<ClickThroughSlide>() {
          public void apply(final ClickThroughSlide it) {
            Pane _pane = it.getPane();
            ObservableList<Node> _children = _pane.getChildren();
            ImageView _imageView = new ImageView();
            final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/darkness1.png");
                it.setImage(_image);
                it.setOpacity(0.8);
                it.setLayoutX(45);
                it.setLayoutY(45);
              }
            };
            ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
            _children.add(_doubleArrow);
            Pane _pane_1 = it.getPane();
            ObservableList<Node> _children_1 = _pane_1.getChildren();
            ImageView _imageView_1 = new ImageView();
            final Procedure1<ImageView> _function_1 = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/darkness2.png");
                it.setImage(_image);
                it.setOpacity(0.8);
                it.setLayoutX(420);
                it.setLayoutY(374);
              }
            };
            ImageView _doubleArrow_1 = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView_1, _function_1);
            _children_1.add(_doubleArrow_1);
          }
        };
        ClickThroughSlide _doubleArrow_2 = ObjectExtensions.<ClickThroughSlide>operator_doubleArrow(_clickThroughSlide, _function_2);
        _slides_4.add(_doubleArrow_2);
        List<Slide> _slides_5 = it.getSlides();
        Slide _slide_4 = new Slide("Behavior", 144);
        _slides_5.add(_slide_4);
        List<Slide> _slides_6 = it.getSlides();
        ClickThroughSlide _clickThroughSlide_1 = new ClickThroughSlide("Behavior images");
        final Procedure1<ClickThroughSlide> _function_3 = new Procedure1<ClickThroughSlide>() {
          public void apply(final ClickThroughSlide it) {
            Pane _pane = it.getPane();
            ObservableList<Node> _children = _pane.getChildren();
            ImageView _imageView = new ImageView();
            final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/graphiti.png");
                it.setImage(_image);
                it.setOpacity(0.8);
                it.setLayoutX(50);
                it.setLayoutY(44);
              }
            };
            ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
            _children.add(_doubleArrow);
            Pane _pane_1 = it.getPane();
            ObservableList<Node> _children_1 = _pane_1.getChildren();
            MediaView _mediaView = new MediaView();
            final Procedure1<MediaView> _function_1 = new Procedure1<MediaView>() {
              public void apply(final MediaView it) {
                it.setOpacity(0.9);
                it.setLayoutX(295);
                it.setLayoutY(332);
                String _uRI = UriExtensions.toURI(IntroductionSlideDeck.this, "/de/fxdiagram/examples/media/Usability.mp4");
                Media _media = new Media(_uRI);
                MediaPlayer _mediaPlayer = new MediaPlayer(_media);
                final Procedure1<MediaPlayer> _function = new Procedure1<MediaPlayer>() {
                  public void apply(final MediaPlayer it) {
                    Duration _seconds = DurationExtensions.seconds(200);
                    it.seek(_seconds);
                  }
                };
                MediaPlayer _doubleArrow = ObjectExtensions.<MediaPlayer>operator_doubleArrow(_mediaPlayer, _function);
                it.setMediaPlayer(_doubleArrow);
              }
            };
            MediaView _doubleArrow_1 = ObjectExtensions.<MediaView>operator_doubleArrow(_mediaView, _function_1);
            _children_1.add(_doubleArrow_1);
          }
        };
        ClickThroughSlide _doubleArrow_3 = ObjectExtensions.<ClickThroughSlide>operator_doubleArrow(_clickThroughSlide_1, _function_3);
        _slides_6.add(_doubleArrow_3);
        List<Slide> _slides_7 = it.getSlides();
        Slide _slide_5 = new Slide("Recycling", 144);
        _slides_7.add(_slide_5);
        List<Slide> _slides_8 = it.getSlides();
        ClickThroughSlide _clickThroughSlide_2 = new ClickThroughSlide("Recycling images");
        final Procedure1<ClickThroughSlide> _function_4 = new Procedure1<ClickThroughSlide>() {
          public void apply(final ClickThroughSlide it) {
            Pane _pane = it.getPane();
            final Procedure1<Pane> _function = new Procedure1<Pane>() {
              public void apply(final Pane it) {
                ObservableList<Node> _children = it.getChildren();
                ImageView _imageView = new ImageView();
                final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
                  public void apply(final ImageView it) {
                    ImageCache _get = ImageCache.get();
                    Image _image = _get.getImage(IntroductionSlideDeck.this, "images/onion.png");
                    it.setImage(_image);
                    it.setFitWidth(570);
                    it.setPreserveRatio(true);
                    it.setLayoutX(227);
                    it.setLayoutY(110);
                  }
                };
                ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
                _children.add(_doubleArrow);
                ObservableList<Node> _children_1 = it.getChildren();
                Group _group = new Group();
                final Procedure1<Group> _function_1 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("OS", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(173);
                        it.setLayoutY(216);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(244.0), Double.valueOf(226.0), Double.valueOf(537.0), Double.valueOf(356.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_1 = ObjectExtensions.<Group>operator_doubleArrow(_group, _function_1);
                _children_1.add(_doubleArrow_1);
                ObservableList<Node> _children_2 = it.getChildren();
                Group _group_1 = new Group();
                final Procedure1<Group> _function_2 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("SWT", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(62);
                        it.setLayoutY(458);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(176.0), Double.valueOf(439.0), Double.valueOf(501.0), Double.valueOf(367.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_2 = ObjectExtensions.<Group>operator_doubleArrow(_group_1, _function_2);
                _children_2.add(_doubleArrow_2);
                ObservableList<Node> _children_3 = it.getChildren();
                Group _group_2 = new Group();
                final Procedure1<Group> _function_3 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("Draw2D", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(129);
                        it.setLayoutY(666);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(307.0), Double.valueOf(611.0), Double.valueOf(489.0), Double.valueOf(433.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_3 = ObjectExtensions.<Group>operator_doubleArrow(_group_2, _function_3);
                _children_3.add(_doubleArrow_3);
                ObservableList<Node> _children_4 = it.getChildren();
                Group _group_3 = new Group();
                final Procedure1<Group> _function_4 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("GEF MVC", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(581);
                        it.setLayoutY(712);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(714.0), Double.valueOf(662.0), Double.valueOf(588.0), Double.valueOf(458.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_4 = ObjectExtensions.<Group>operator_doubleArrow(_group_3, _function_4);
                _children_4.add(_doubleArrow_4);
                ObservableList<Node> _children_5 = it.getChildren();
                Group _group_4 = new Group();
                final Procedure1<Group> _function_5 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("GMF");
                    _builder.newLine();
                    _builder.append("Runtime");
                    Text _createJungleText = Styles.createJungleText(_builder.toString(), 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(770);
                        it.setLayoutY(462);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(803.0), Double.valueOf(462.0), Double.valueOf(658.0), Double.valueOf(416.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_5 = ObjectExtensions.<Group>operator_doubleArrow(_group_4, _function_5);
                _children_5.add(_doubleArrow_5);
                ObservableList<Node> _children_6 = it.getChildren();
                Group _group_5 = new Group();
                final Procedure1<Group> _function_6 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("GMF");
                    _builder.newLine();
                    _builder.append("Tooling");
                    Text _createJungleText = Styles.createJungleText(_builder.toString(), 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(770);
                        it.setLayoutY(184);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(766.0), Double.valueOf(206.0), Double.valueOf(662.0), Double.valueOf(281.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_6 = ObjectExtensions.<Group>operator_doubleArrow(_group_5, _function_6);
                _children_6.add(_doubleArrow_6);
                ObservableList<Node> _children_7 = it.getChildren();
                Group _group_6 = new Group();
                final Procedure1<Group> _function_7 = new Procedure1<Group>() {
                  public void apply(final Group it) {
                    ObservableList<Node> _children = it.getChildren();
                    Text _createJungleText = Styles.createJungleText("Epsilon", 48);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        it.setLayoutX(405);
                        it.setLayoutY(88);
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createJungleText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Polyline _polyline = new Polyline();
                    final Procedure1<Polyline> _function_1 = new Procedure1<Polyline>() {
                      public void apply(final Polyline it) {
                        ObservableList<Double> _points = it.getPoints();
                        Iterables.<Double>addAll(_points, Collections.<Double>unmodifiableList(Lists.<Double>newArrayList(Double.valueOf(519.0), Double.valueOf(101.0), Double.valueOf(525.0), Double.valueOf(188.0))));
                        Color _jungleGreen = Styles.jungleGreen();
                        it.setStroke(_jungleGreen);
                        it.setStrokeWidth(2);
                      }
                    };
                    Polyline _doubleArrow_1 = ObjectExtensions.<Polyline>operator_doubleArrow(_polyline, _function_1);
                    _children_1.add(_doubleArrow_1);
                  }
                };
                Group _doubleArrow_7 = ObjectExtensions.<Group>operator_doubleArrow(_group_6, _function_7);
                _children_7.add(_doubleArrow_7);
              }
            };
            ObjectExtensions.<Pane>operator_doubleArrow(_pane, _function);
          }
        };
        ClickThroughSlide _doubleArrow_4 = ObjectExtensions.<ClickThroughSlide>operator_doubleArrow(_clickThroughSlide_2, _function_4);
        _slides_8.add(_doubleArrow_4);
        List<Slide> _slides_9 = it.getSlides();
        Slide _slide_6 = new Slide("Reproduction", 144);
        _slides_9.add(_slide_6);
        List<Slide> _slides_10 = it.getSlides();
        ClickThroughSlide _clickThroughSlide_3 = new ClickThroughSlide("Reproduction images");
        final Procedure1<ClickThroughSlide> _function_5 = new Procedure1<ClickThroughSlide>() {
          public void apply(final ClickThroughSlide it) {
            Pane _pane = it.getPane();
            ObservableList<Node> _children = _pane.getChildren();
            ImageView _imageView = new ImageView();
            final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/graphiti_code.png");
                it.setImage(_image);
                it.setLayoutX(43);
                it.setLayoutY(41);
                it.setOpacity(0.8);
              }
            };
            ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
            _children.add(_doubleArrow);
            Pane _pane_1 = it.getPane();
            ObservableList<Node> _children_1 = _pane_1.getChildren();
            VBox _vBox = new VBox();
            final Procedure1<VBox> _function_1 = new Procedure1<VBox>() {
              public void apply(final VBox it) {
                it.setLayoutX(313);
                it.setLayoutY(81);
                Insets _insets = new Insets(5, 5, 5, 5);
                it.setPadding(_insets);
                it.setAlignment(Pos.CENTER);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("-fx-border-color: black;");
                _builder.newLine();
                _builder.append("-fx-border-width: 1;");
                _builder.newLine();
                _builder.append("-fx-background-color: rgb(252,228,153);");
                _builder.newLine();
                it.setStyle(_builder.toString());
                ObservableList<Node> _children = it.getChildren();
                Text _createText = Styles.createText("34 Files", 24);
                final Procedure1<Text> _function = new Procedure1<Text>() {
                  public void apply(final Text it) {
                    it.setFill(Color.BLACK);
                  }
                };
                Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createText, _function);
                _children.add(_doubleArrow);
                ObservableList<Node> _children_1 = it.getChildren();
                Text _createText_1 = Styles.createText("2730 LOC", 24);
                final Procedure1<Text> _function_1 = new Procedure1<Text>() {
                  public void apply(final Text it) {
                    it.setFill(Color.BLACK);
                  }
                };
                Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(_createText_1, _function_1);
                _children_1.add(_doubleArrow_1);
              }
            };
            VBox _doubleArrow_1 = ObjectExtensions.<VBox>operator_doubleArrow(_vBox, _function_1);
            _children_1.add(_doubleArrow_1);
            Pane _pane_2 = it.getPane();
            ObservableList<Node> _children_2 = _pane_2.getChildren();
            ImageView _imageView_1 = new ImageView();
            final Procedure1<ImageView> _function_2 = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/gmf_dashboard.png");
                it.setImage(_image);
                it.setLayoutX(284);
                it.setLayoutY(406);
                it.setOpacity(0.8);
              }
            };
            ImageView _doubleArrow_2 = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView_1, _function_2);
            _children_2.add(_doubleArrow_2);
          }
        };
        ClickThroughSlide _doubleArrow_5 = ObjectExtensions.<ClickThroughSlide>operator_doubleArrow(_clickThroughSlide_3, _function_5);
        _slides_10.add(_doubleArrow_5);
        List<Slide> _slides_11 = it.getSlides();
        Slide _slide_7 = new Slide("Endangerment", 144);
        _slides_11.add(_slide_7);
        List<Slide> _slides_12 = it.getSlides();
        ClickThroughSlide _clickThroughSlide_4 = new ClickThroughSlide("Tablet");
        final Procedure1<ClickThroughSlide> _function_6 = new Procedure1<ClickThroughSlide>() {
          public void apply(final ClickThroughSlide it) {
            Pane _pane = it.getPane();
            ObservableList<Node> _children = _pane.getChildren();
            ImageView _imageView = new ImageView();
            final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/tablet.png");
                it.setImage(_image);
                it.setLayoutX(183);
                it.setLayoutY(210);
                it.setFitWidth(587);
                it.setPreserveRatio(true);
              }
            };
            ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
            _children.add(_doubleArrow);
            Pane _pane_1 = it.getPane();
            ObservableList<Node> _children_1 = _pane_1.getChildren();
            ImageView _imageView_1 = new ImageView();
            final Procedure1<ImageView> _function_1 = new Procedure1<ImageView>() {
              public void apply(final ImageView it) {
                ImageCache _get = ImageCache.get();
                Image _image = _get.getImage(IntroductionSlideDeck.this, "images/hand.png");
                it.setImage(_image);
                it.setLayoutX(540);
                it.setLayoutY(244);
              }
            };
            ImageView _doubleArrow_1 = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView_1, _function_1);
            _children_1.add(_doubleArrow_1);
          }
        };
        ClickThroughSlide _doubleArrow_6 = ObjectExtensions.<ClickThroughSlide>operator_doubleArrow(_clickThroughSlide_4, _function_6);
        _slides_12.add(_doubleArrow_6);
        List<Slide> _slides_13 = it.getSlides();
        Slide _slide_8 = new Slide("Help");
        final Procedure1<Slide> _function_7 = new Procedure1<Slide>() {
          public void apply(final Slide it) {
            StackPane _stackPane = it.getStackPane();
            final Procedure1<StackPane> _function = new Procedure1<StackPane>() {
              public void apply(final StackPane it) {
                ObservableList<Node> _children = it.getChildren();
                VBox _vBox = new VBox();
                final Procedure1<VBox> _function = new Procedure1<VBox>() {
                  public void apply(final VBox it) {
                    it.setAlignment(Pos.CENTER);
                    it.setSpacing(50);
                    ObservableList<Node> _children = it.getChildren();
                    Text _createText = Styles.createText("Help Us", 144);
                    final Procedure1<Text> _function = new Procedure1<Text>() {
                      public void apply(final Text it) {
                      }
                    };
                    Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_createText, _function);
                    _children.add(_doubleArrow);
                    ObservableList<Node> _children_1 = it.getChildren();
                    Text _createText_1 = Styles.createText("save the", 72);
                    final Procedure1<Text> _function_1 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                      }
                    };
                    Text _doubleArrow_1 = ObjectExtensions.<Text>operator_doubleArrow(_createText_1, _function_1);
                    _children_1.add(_doubleArrow_1);
                    ObservableList<Node> _children_2 = it.getChildren();
                    Text _createText_2 = Styles.createText("Eclipse Diagram Editors", 96);
                    final Procedure1<Text> _function_2 = new Procedure1<Text>() {
                      public void apply(final Text it) {
                        Color _rgb = Color.rgb(238, 191, 171);
                        it.setFill(_rgb);
                      }
                    };
                    Text _doubleArrow_2 = ObjectExtensions.<Text>operator_doubleArrow(_createText_2, _function_2);
                    _children_2.add(_doubleArrow_2);
                  }
                };
                VBox _doubleArrow = ObjectExtensions.<VBox>operator_doubleArrow(_vBox, _function);
                _children.add(_doubleArrow);
              }
            };
            ObjectExtensions.<StackPane>operator_doubleArrow(_stackPane, _function);
          }
        };
        Slide _doubleArrow_7 = ObjectExtensions.<Slide>operator_doubleArrow(_slide_8, _function_7);
        _slides_13.add(_doubleArrow_7);
        List<Slide> _slides_14 = it.getSlides();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("We have improve visual design,");
        _builder.newLine();
        _builder.append("haptic behavior,");
        _builder.newLine();
        _builder.append("usability,");
        _builder.newLine();
        _builder.append("and customizability");
        _builder.newLine();
        _builder.append("in order to save them from extinction.");
        _builder.newLine();
        Slide _slide_9 = new Slide(_builder.toString(), 48);
        _slides_14.add(_slide_9);
        List<Slide> _slides_15 = it.getSlides();
        Slide _slide_10 = new Slide("JavaFX");
        final Procedure1<Slide> _function_8 = new Procedure1<Slide>() {
          public void apply(final Slide it) {
            StackPane _stackPane = it.getStackPane();
            final Procedure1<StackPane> _function = new Procedure1<StackPane>() {
              public void apply(final StackPane it) {
                ObservableList<Node> _children = it.getChildren();
                ImageView _imageView = new ImageView();
                final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
                  public void apply(final ImageView it) {
                    ImageCache _get = ImageCache.get();
                    Image _image = _get.getImage(IntroductionSlideDeck.this, "images/javafx.png");
                    it.setImage(_image);
                    it.setFitWidth(587);
                    it.setPreserveRatio(true);
                  }
                };
                ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
                _children.add(_doubleArrow);
              }
            };
            ObjectExtensions.<StackPane>operator_doubleArrow(_stackPane, _function);
          }
        };
        Slide _doubleArrow_8 = ObjectExtensions.<Slide>operator_doubleArrow(_slide_10, _function_8);
        _slides_15.add(_doubleArrow_8);
      }
    };
    SlideDiagram _doubleArrow = ObjectExtensions.<SlideDiagram>operator_doubleArrow(_slideDiagram, _function);
    this.setInnerDiagram(_doubleArrow);
  }
}
