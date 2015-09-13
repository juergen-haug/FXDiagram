package de.fxdiagram.lib.nodes;

import com.google.common.base.Objects;
import de.fxdiagram.core.behavior.AbstractReconcileBehavior;
import de.fxdiagram.core.behavior.DirtyState;
import de.fxdiagram.core.behavior.UpdateAcceptor;
import de.fxdiagram.core.command.SequentialAnimationCommand;
import de.fxdiagram.lib.nodes.AbstractClassNode;
import de.fxdiagram.lib.nodes.ClassModel;
import java.util.NoSuchElementException;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ClassModelReconcileBehavior extends AbstractReconcileBehavior<AbstractClassNode> {
  public ClassModelReconcileBehavior(final AbstractClassNode host) {
    super(host);
  }
  
  @Override
  public DirtyState getDirtyState() {
    DirtyState _xtrycatchfinallyexpression = null;
    try {
      DirtyState _xblockexpression = null;
      {
        AbstractClassNode _host = this.getHost();
        final ClassModel newModel = _host.inferClassModel();
        DirtyState _xifexpression = null;
        boolean _equals = Objects.equal(newModel, null);
        if (_equals) {
          _xifexpression = DirtyState.DANGLING;
        } else {
          DirtyState _xifexpression_1 = null;
          AbstractClassNode _host_1 = this.getHost();
          ClassModel _model = _host_1.getModel();
          boolean _notEquals = (!Objects.equal(_model, newModel));
          if (_notEquals) {
            _xifexpression_1 = DirtyState.DIRTY;
          } else {
            _xifexpression_1 = DirtyState.CLEAN;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException exc = (NoSuchElementException)_t;
        return DirtyState.DANGLING;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Override
  public void reconcile(final UpdateAcceptor acceptor) {
    try {
      AbstractClassNode _host = this.getHost();
      final ClassModel newModel = _host.inferClassModel();
      boolean _notEquals = (!Objects.equal(newModel, null));
      if (_notEquals) {
        AbstractClassNode _host_1 = this.getHost();
        ClassModel _model = _host_1.getModel();
        boolean _notEquals_1 = (!Objects.equal(_model, newModel));
        if (_notEquals_1) {
          AbstractClassNode _host_2 = this.getHost();
          SequentialAnimationCommand _createMorphCommand = _host_2.createMorphCommand(newModel);
          acceptor.morph(_createMorphCommand);
        }
        return;
      }
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchElementException) {
        final NoSuchElementException exc = (NoSuchElementException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    AbstractClassNode _host_3 = this.getHost();
    acceptor.delete(_host_3);
  }
}