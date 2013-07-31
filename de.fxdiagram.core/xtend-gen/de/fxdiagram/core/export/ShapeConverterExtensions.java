package de.fxdiagram.core.export;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Text;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Copied from the <a href="https://github.com/JFXtras">JFXtras</a> project and converted to Xtend.
 */
@SuppressWarnings("all")
public class ShapeConverterExtensions {
  private final static double KAPPA = 0.5522847498307935;
  
  public static SVGPath toSvgPath(final Shape shape) {
    SVGPath _sVGPath = new SVGPath();
    final Procedure1<SVGPath> _function = new Procedure1<SVGPath>() {
      public void apply(final SVGPath it) {
        String _svgString = ShapeConverterExtensions.toSvgString(shape);
        it.setContent(_svgString);
      }
    };
    SVGPath _doubleArrow = ObjectExtensions.<SVGPath>operator_doubleArrow(_sVGPath, _function);
    return _doubleArrow;
  }
  
  public static String toSvgString(final Shape shape) {
    String _internalToSvgString = ShapeConverterExtensions.internalToSvgString(shape);
    String _replaceAll = _internalToSvgString.replaceAll("\\s+", " ");
    String _trim = _replaceAll.trim();
    return _trim;
  }
  
  protected static String _internalToSvgString(final SVGPath svgPath) {
    String _content = svgPath.getContent();
    return _content;
  }
  
  protected static String _internalToSvgString(final Text text) {
    String _xblockexpression = null;
    {
      Rectangle _rectangle = new Rectangle(0, 0);
      Shape _subtract = Shape.subtract(text, _rectangle);
      final Path path = ((Path) _subtract);
      String _svgString = ShapeConverterExtensions.toSvgString(path);
      _xblockexpression = (_svgString);
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final Line line) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("M ");
    double _startX = line.getStartX();
    _builder.append(_startX, "");
    _builder.append(" ");
    double _startY = line.getStartY();
    _builder.append(_startY, "");
    _builder.append(" L ");
    double _endX = line.getEndX();
    _builder.append(_endX, "");
    _builder.append(" ");
    double _endY = line.getEndY();
    _builder.append(_endY, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected static String _internalToSvgString(final Arc arc) {
    String _xblockexpression = null;
    {
      final double centerX = arc.getCenterX();
      final double centerY = arc.getCenterY();
      final double radiusX = arc.getRadiusX();
      final double radiusY = arc.getRadiusY();
      double _startAngle = arc.getStartAngle();
      final double startAngle = Math.toRadians(_startAngle);
      final double length = arc.getLength();
      double _length = arc.getLength();
      double _plus = (_length + startAngle);
      final double alpha = Math.toRadians(_plus);
      int _minus = (-90);
      final double phiOffset = Math.toRadians(_minus);
      double _cos = Math.cos(phiOffset);
      double _multiply = (_cos * radiusX);
      double _cos_1 = Math.cos(startAngle);
      double _multiply_1 = (_multiply * _cos_1);
      double _plus_1 = (centerX + _multiply_1);
      double _minus_1 = (-phiOffset);
      double _sin = Math.sin(_minus_1);
      double _multiply_2 = (_sin * radiusY);
      double _sin_1 = Math.sin(startAngle);
      double _multiply_3 = (_multiply_2 * _sin_1);
      final double startX = (_plus_1 + _multiply_3);
      double _sin_2 = Math.sin(phiOffset);
      double _multiply_4 = (_sin_2 * radiusX);
      double _cos_2 = Math.cos(startAngle);
      double _multiply_5 = (_multiply_4 * _cos_2);
      double _plus_2 = (centerY + _multiply_5);
      double _cos_3 = Math.cos(phiOffset);
      double _multiply_6 = (_cos_3 * radiusY);
      double _sin_3 = Math.sin(startAngle);
      double _multiply_7 = (_multiply_6 * _sin_3);
      final double startY = (_plus_2 + _multiply_7);
      double _cos_4 = Math.cos(phiOffset);
      double _multiply_8 = (_cos_4 * radiusX);
      double _cos_5 = Math.cos(alpha);
      double _multiply_9 = (_multiply_8 * _cos_5);
      double _plus_3 = (centerX + _multiply_9);
      double _minus_2 = (-phiOffset);
      double _sin_4 = Math.sin(_minus_2);
      double _multiply_10 = (_sin_4 * radiusY);
      double _sin_5 = Math.sin(alpha);
      double _multiply_11 = (_multiply_10 * _sin_5);
      final double endX = (_plus_3 + _multiply_11);
      double _sin_6 = Math.sin(phiOffset);
      double _multiply_12 = (_sin_6 * radiusX);
      double _cos_6 = Math.cos(alpha);
      double _multiply_13 = (_multiply_12 * _cos_6);
      double _plus_4 = (centerY + _multiply_13);
      double _cos_7 = Math.cos(phiOffset);
      double _multiply_14 = (_cos_7 * radiusY);
      double _sin_7 = Math.sin(alpha);
      double _multiply_15 = (_multiply_14 * _sin_7);
      final double endY = (_plus_4 + _multiply_15);
      final int xAxisRot = 0;
      int _xifexpression = (int) 0;
      boolean _greaterThan = (length > 180);
      if (_greaterThan) {
        _xifexpression = 1;
      } else {
        _xifexpression = 0;
      }
      final int largeArc = _xifexpression;
      int _xifexpression_1 = (int) 0;
      boolean _greaterThan_1 = (length > 0);
      if (_greaterThan_1) {
        _xifexpression_1 = 1;
      } else {
        _xifexpression_1 = 0;
      }
      final int sweep = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("M ");
      _builder.append(centerX, "");
      _builder.append(" ");
      _builder.append(centerY, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      {
        ArcType _type = arc.getType();
        boolean _equals = Objects.equal(ArcType.ROUND, _type);
        if (_equals) {
          _builder.append("h ");
          double _minus_3 = (startX - centerX);
          _builder.append(_minus_3, "");
          _builder.append(" v ");
          double _minus_4 = (startY - centerY);
          _builder.append(_minus_4, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("A ");
      _builder.append(radiusX, "");
      _builder.append(" ");
      _builder.append(radiusY, "");
      _builder.append(" ");
      _builder.append(xAxisRot, "");
      _builder.append(" ");
      _builder.append(largeArc, "");
      _builder.append(" ");
      _builder.append(sweep, "");
      _builder.append(" ");
      _builder.append(endX, "");
      _builder.append(" ");
      _builder.append(endY, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      {
        boolean _or = false;
        ArcType _type_1 = arc.getType();
        boolean _equals_1 = Objects.equal(ArcType.CHORD, _type_1);
        if (_equals_1) {
          _or = true;
        } else {
          ArcType _type_2 = arc.getType();
          boolean _equals_2 = Objects.equal(ArcType.ROUND, _type_2);
          _or = (_equals_1 || _equals_2);
        }
        if (_or) {
          _builder.append("Z");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final QuadCurve quadCurve) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("M ");
    double _startX = quadCurve.getStartX();
    _builder.append(_startX, "");
    _builder.append(" ");
    double _startY = quadCurve.getStartY();
    _builder.append(_startY, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("Q ");
    double _controlX = quadCurve.getControlX();
    _builder.append(_controlX, "");
    _builder.append(" ");
    double _controlY = quadCurve.getControlY();
    _builder.append(_controlY, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    double _endX = quadCurve.getEndX();
    _builder.append(_endX, "");
    _builder.append(" ");
    double _endY = quadCurve.getEndY();
    _builder.append(_endY, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected static String _internalToSvgString(final CubicCurve cubicCurve) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("M ");
    double _startX = cubicCurve.getStartX();
    _builder.append(_startX, "");
    _builder.append(" ");
    double _startY = cubicCurve.getStartY();
    _builder.append(_startY, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("C ");
    double _controlX1 = cubicCurve.getControlX1();
    _builder.append(_controlX1, "");
    _builder.append(" ");
    double _controlY1 = cubicCurve.getControlY1();
    _builder.append(_controlY1, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    double _controlX2 = cubicCurve.getControlX2();
    _builder.append(_controlX2, "");
    _builder.append(" ");
    double _controlY2 = cubicCurve.getControlY2();
    _builder.append(_controlY2, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    double _endX = cubicCurve.getEndX();
    _builder.append(_endX, "");
    _builder.append(" ");
    double _endY = cubicCurve.getEndY();
    _builder.append(_endY, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected static String _internalToSvgString(final Rectangle rectangle) {
    String _xblockexpression = null;
    {
      final Bounds bounds = rectangle.getBoundsInLocal();
      String _xifexpression = null;
      boolean _and = false;
      double _arcWidth = rectangle.getArcWidth();
      int _spaceship = (Double.valueOf(_arcWidth).compareTo(Double.valueOf(0.0)));
      boolean _equals = (_spaceship == 0);
      if (!_equals) {
        _and = false;
      } else {
        double _arcHeight = rectangle.getArcHeight();
        int _spaceship_1 = (Double.valueOf(_arcHeight).compareTo(Double.valueOf(0.0)));
        boolean _equals_1 = (_spaceship_1 == 0);
        _and = (_equals && _equals_1);
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("M ");
        double _minX = bounds.getMinX();
        _builder.append(_minX, "");
        _builder.append(" ");
        double _minY = bounds.getMinY();
        _builder.append(_minY, "");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("H ");
        double _maxX = bounds.getMaxX();
        _builder.append(_maxX, "");
        _builder.append(" V ");
        double _maxY = bounds.getMaxY();
        _builder.append(_maxY, "");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("H ");
        double _minX_1 = bounds.getMinX();
        _builder.append(_minX_1, "");
        _builder.append(" V ");
        double _minY_1 = bounds.getMinY();
        _builder.append(_minY_1, "");
        _builder.append(" Z");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder.toString();
      } else {
        String _xblockexpression_1 = null;
        {
          final double x = bounds.getMinX();
          final double y = bounds.getMinY();
          final double width = bounds.getWidth();
          final double height = bounds.getHeight();
          final double arcWidth = rectangle.getArcWidth();
          final double arcHeight = rectangle.getArcHeight();
          final double r = (x + width);
          final double b = (y + height);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("M ");
          double _plus = (x + arcWidth);
          _builder_1.append(_plus, "");
          _builder_1.append(" ");
          _builder_1.append(y, "");
          _builder_1.append(" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("L ");
          double _minus = (r - arcWidth);
          _builder_1.append(_minus, "");
          _builder_1.append(" ");
          _builder_1.append(y, "");
          _builder_1.append(" Q ");
          _builder_1.append(r, "");
          _builder_1.append(" ");
          _builder_1.append(y, "");
          _builder_1.append(" ");
          _builder_1.append(r, "");
          _builder_1.append(" ");
          double _plus_1 = (y + arcHeight);
          _builder_1.append(_plus_1, "");
          _builder_1.append(" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("L ");
          _builder_1.append(r, "");
          _builder_1.append(" ");
          double _plus_2 = (y + height);
          double _minus_1 = (_plus_2 - arcHeight);
          _builder_1.append(_minus_1, "");
          _builder_1.append(" Q ");
          _builder_1.append(r, "");
          _builder_1.append(" ");
          _builder_1.append(b, "");
          _builder_1.append(" ");
          double _minus_2 = (r - arcWidth);
          _builder_1.append(_minus_2, "");
          _builder_1.append(" ");
          _builder_1.append(b, "");
          _builder_1.append(" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("L ");
          double _plus_3 = (x + arcWidth);
          _builder_1.append(_plus_3, "");
          _builder_1.append(" ");
          _builder_1.append(b, "");
          _builder_1.append(" Q ");
          _builder_1.append(x, "");
          _builder_1.append(" ");
          _builder_1.append(b, "");
          _builder_1.append(" ");
          _builder_1.append(x, "");
          _builder_1.append(" ");
          double _minus_3 = (b - arcHeight);
          _builder_1.append(_minus_3, "");
          _builder_1.append(" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("L ");
          _builder_1.append(x, "");
          _builder_1.append(" ");
          double _plus_4 = (y + arcHeight);
          _builder_1.append(_plus_4, "");
          _builder_1.append(" Q ");
          _builder_1.append(x, "");
          _builder_1.append(" ");
          _builder_1.append(y, "");
          _builder_1.append(" ");
          double _plus_5 = (x + arcWidth);
          _builder_1.append(_plus_5, "");
          _builder_1.append(" ");
          _builder_1.append(y, "");
          _builder_1.append(" Z");
          _builder_1.newLineIfNotEmpty();
          _xblockexpression_1 = (_builder_1.toString());
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final Circle circle) {
    String _xblockexpression = null;
    {
      double _xifexpression = (double) 0;
      double _centerX = circle.getCenterX();
      boolean _equals = (_centerX == 0);
      if (_equals) {
        double _radius = circle.getRadius();
        _xifexpression = _radius;
      } else {
        double _centerX_1 = circle.getCenterX();
        _xifexpression = _centerX_1;
      }
      final double centerX = _xifexpression;
      double _xifexpression_1 = (double) 0;
      double _centerY = circle.getCenterY();
      boolean _equals_1 = (_centerY == 0);
      if (_equals_1) {
        double _radius_1 = circle.getRadius();
        _xifexpression_1 = _radius_1;
      } else {
        double _centerY_1 = circle.getCenterY();
        _xifexpression_1 = _centerY_1;
      }
      final double centerY = _xifexpression_1;
      final double radius = circle.getRadius();
      final double controlDistance = (radius * ShapeConverterExtensions.KAPPA);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("M ");
      _builder.append(centerX, "");
      _builder.append(" ");
      double _minus = (centerY - radius);
      _builder.append(_minus, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _plus = (centerX + controlDistance);
      _builder.append(_plus, "");
      _builder.append(" ");
      double _minus_1 = (centerY - radius);
      _builder.append(_minus_1, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_1 = (centerX + radius);
      _builder.append(_plus_1, "");
      _builder.append(" ");
      double _minus_2 = (centerY - controlDistance);
      _builder.append(_minus_2, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_2 = (centerX + radius);
      _builder.append(_plus_2, "");
      _builder.append(" ");
      _builder.append(centerY, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _plus_3 = (centerX + radius);
      _builder.append(_plus_3, "");
      _builder.append(" ");
      double _plus_4 = (centerY + controlDistance);
      _builder.append(_plus_4, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_5 = (centerX + controlDistance);
      _builder.append(_plus_5, "");
      _builder.append(" ");
      double _plus_6 = (centerY + radius);
      _builder.append(_plus_6, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append(centerX, "");
      _builder.append(" ");
      double _plus_7 = (centerY + radius);
      _builder.append(_plus_7, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _minus_3 = (centerX - controlDistance);
      _builder.append(_minus_3, "");
      _builder.append(" ");
      double _plus_8 = (centerY + radius);
      _builder.append(_plus_8, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_4 = (centerX - radius);
      _builder.append(_minus_4, "");
      _builder.append(" ");
      double _plus_9 = (centerY + controlDistance);
      _builder.append(_plus_9, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_5 = (centerX - radius);
      _builder.append(_minus_5, "");
      _builder.append(" ");
      _builder.append(centerY, "");
      _builder.append("  ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _minus_6 = (centerX - radius);
      _builder.append(_minus_6, "");
      _builder.append(" ");
      double _minus_7 = (centerY - controlDistance);
      _builder.append(_minus_7, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_8 = (centerX - controlDistance);
      _builder.append(_minus_8, "");
      _builder.append(" ");
      double _minus_9 = (centerY - radius);
      _builder.append(_minus_9, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append(centerX, "");
      _builder.append(" ");
      double _minus_10 = (centerY - radius);
      _builder.append(_minus_10, "");
      _builder.append(" Z");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final Ellipse ellipse) {
    String _xblockexpression = null;
    {
      double _xifexpression = (double) 0;
      double _centerX = ellipse.getCenterX();
      boolean _equals = (_centerX == 0);
      if (_equals) {
        double _radiusX = ellipse.getRadiusX();
        _xifexpression = _radiusX;
      } else {
        double _centerX_1 = ellipse.getCenterX();
        _xifexpression = _centerX_1;
      }
      final double centerX = _xifexpression;
      double _xifexpression_1 = (double) 0;
      double _centerY = ellipse.getCenterY();
      boolean _equals_1 = (_centerY == 0);
      if (_equals_1) {
        double _radiusY = ellipse.getRadiusY();
        _xifexpression_1 = _radiusY;
      } else {
        double _centerY_1 = ellipse.getCenterY();
        _xifexpression_1 = _centerY_1;
      }
      final double centerY = _xifexpression_1;
      final double radiusX = ellipse.getRadiusX();
      final double radiusY = ellipse.getRadiusY();
      final double controlDistanceX = (radiusX * ShapeConverterExtensions.KAPPA);
      final double controlDistanceY = (radiusY * ShapeConverterExtensions.KAPPA);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("M ");
      _builder.append(centerX, "");
      _builder.append(" ");
      double _minus = (centerY - radiusY);
      _builder.append(_minus, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _plus = (centerX + controlDistanceX);
      _builder.append(_plus, "");
      _builder.append(" ");
      double _minus_1 = (centerY - radiusY);
      _builder.append(_minus_1, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_1 = (centerX + radiusX);
      _builder.append(_plus_1, "");
      _builder.append(" ");
      double _minus_2 = (centerY - controlDistanceY);
      _builder.append(_minus_2, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_2 = (centerX + radiusX);
      _builder.append(_plus_2, "");
      _builder.append(" ");
      _builder.append(centerY, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _plus_3 = (centerX + radiusX);
      _builder.append(_plus_3, "");
      _builder.append(" ");
      double _plus_4 = (centerY + controlDistanceY);
      _builder.append(_plus_4, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _plus_5 = (centerX + controlDistanceX);
      _builder.append(_plus_5, "");
      _builder.append(" ");
      double _plus_6 = (centerY + radiusY);
      _builder.append(_plus_6, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append(centerX, "");
      _builder.append(" ");
      double _plus_7 = (centerY + radiusY);
      _builder.append(_plus_7, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _minus_3 = (centerX - controlDistanceX);
      _builder.append(_minus_3, "");
      _builder.append(" ");
      double _plus_8 = (centerY + radiusY);
      _builder.append(_plus_8, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_4 = (centerX - radiusX);
      _builder.append(_minus_4, "");
      _builder.append(" ");
      double _plus_9 = (centerY + controlDistanceY);
      _builder.append(_plus_9, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_5 = (centerX - radiusX);
      _builder.append(_minus_5, "");
      _builder.append(" ");
      _builder.append(centerY, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("C ");
      double _minus_6 = (centerX - radiusX);
      _builder.append(_minus_6, "");
      _builder.append(" ");
      double _minus_7 = (centerY - controlDistanceY);
      _builder.append(_minus_7, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      double _minus_8 = (centerX - controlDistanceX);
      _builder.append(_minus_8, "");
      _builder.append(" ");
      double _minus_9 = (centerY - radiusY);
      _builder.append(_minus_9, "");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append(centerX, "");
      _builder.append(" ");
      double _minus_10 = (centerY - radiusY);
      _builder.append(_minus_10, "");
      _builder.append(" Z");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final Path path) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder it = _stringBuilder;
      ObservableList<PathElement> _elements = path.getElements();
      for (final PathElement element : _elements) {
        boolean _matched = false;
        if (!_matched) {
          if (element instanceof MoveTo) {
            final MoveTo _moveTo = (MoveTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("M ");
            double _x = _moveTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            double _y = _moveTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof LineTo) {
            final LineTo _lineTo = (LineTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("L ");
            double _x = _lineTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            double _y = _lineTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof CubicCurveTo) {
            final CubicCurveTo _cubicCurveTo = (CubicCurveTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("C ");
            double _controlX1 = _cubicCurveTo.getControlX1();
            _builder.append(_controlX1, "");
            _builder.append(" ");
            double _controlY1 = _cubicCurveTo.getControlY1();
            _builder.append(_controlY1, "");
            _builder.append(" ");
            double _controlX2 = _cubicCurveTo.getControlX2();
            _builder.append(_controlX2, "");
            _builder.append(" ");
            double _controlY2 = _cubicCurveTo.getControlY2();
            _builder.append(_controlY2, "");
            _builder.append(" ");
            double _x = _cubicCurveTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            double _y = _cubicCurveTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof QuadCurveTo) {
            final QuadCurveTo _quadCurveTo = (QuadCurveTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Q ");
            double _controlX = _quadCurveTo.getControlX();
            _builder.append(_controlX, "");
            _builder.append(" ");
            double _controlY = _quadCurveTo.getControlY();
            _builder.append(_controlY, "");
            _builder.append(" ");
            double _x = _quadCurveTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            double _y = _quadCurveTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof ArcTo) {
            final ArcTo _arcTo = (ArcTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("A ");
            double _x = _arcTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            double _y = _arcTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            double _radiusX = _arcTo.getRadiusX();
            _builder.append(_radiusX, "");
            _builder.append(" ");
            double _radiusY = _arcTo.getRadiusY();
            _builder.append(_radiusY, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof HLineTo) {
            final HLineTo _hLineTo = (HLineTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("H ");
            double _x = _hLineTo.getX();
            _builder.append(_x, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof VLineTo) {
            final VLineTo _vLineTo = (VLineTo)element;
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("V ");
            double _y = _vLineTo.getY();
            _builder.append(_y, "");
            _builder.append(" ");
            it.append(_builder);
          }
        }
        if (!_matched) {
          if (element instanceof ClosePath) {
            final ClosePath _closePath = (ClosePath)element;
            _matched=true;
            it.append("Z");
          }
        }
      }
      String _string = it.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected static String _internalToSvgString(final Polygon polygon) {
    ObservableList<Double> _points = polygon.getPoints();
    String _pointsToSvgString = ShapeConverterExtensions.pointsToSvgString(_points);
    String _plus = (_pointsToSvgString + "Z");
    return _plus;
  }
  
  protected static String _internalToSvgString(final Polyline polyline) {
    ObservableList<Double> _points = polyline.getPoints();
    String _pointsToSvgString = ShapeConverterExtensions.pointsToSvgString(_points);
    return _pointsToSvgString;
  }
  
  protected static String pointsToSvgString(final List<Double> points) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder it = _stringBuilder;
      final int size = points.size();
      int _modulo = (size % 2);
      boolean _equals = (_modulo == 0);
      if (_equals) {
        final List<Double> coordinates = points;
        int i = 0;
        boolean _lessThan = (i < size);
        boolean _while = _lessThan;
        while (_while) {
          {
            StringConcatenation _builder = new StringConcatenation();
            {
              boolean _equals_1 = (i == 0);
              if (_equals_1) {
                _builder.append("M");
                _builder.newLine();
              } else {
                _builder.append("L");
                _builder.newLine();
              }
            }
            Double _get = coordinates.get(i);
            _builder.append(_get, "");
            _builder.append(" ");
            int _plus = (i + 1);
            Double _get_1 = coordinates.get(_plus);
            _builder.append(_get_1, "");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
            it.append(_builder);
            int _plus_1 = (i + 2);
            i = _plus_1;
          }
          boolean _lessThan_1 = (i < size);
          _while = _lessThan_1;
        }
      }
      String _string = it.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected static String internalToSvgString(final Shape arc) {
    if (arc instanceof Arc) {
      return _internalToSvgString((Arc)arc);
    } else if (arc instanceof Circle) {
      return _internalToSvgString((Circle)arc);
    } else if (arc instanceof CubicCurve) {
      return _internalToSvgString((CubicCurve)arc);
    } else if (arc instanceof Ellipse) {
      return _internalToSvgString((Ellipse)arc);
    } else if (arc instanceof Line) {
      return _internalToSvgString((Line)arc);
    } else if (arc instanceof Path) {
      return _internalToSvgString((Path)arc);
    } else if (arc instanceof Polygon) {
      return _internalToSvgString((Polygon)arc);
    } else if (arc instanceof Polyline) {
      return _internalToSvgString((Polyline)arc);
    } else if (arc instanceof QuadCurve) {
      return _internalToSvgString((QuadCurve)arc);
    } else if (arc instanceof Rectangle) {
      return _internalToSvgString((Rectangle)arc);
    } else if (arc instanceof SVGPath) {
      return _internalToSvgString((SVGPath)arc);
    } else if (arc instanceof Text) {
      return _internalToSvgString((Text)arc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(arc).toString());
    }
  }
}