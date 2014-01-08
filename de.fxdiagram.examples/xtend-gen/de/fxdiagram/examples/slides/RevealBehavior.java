package de.fxdiagram.examples.slides;

import de.fxdiagram.core.behavior.AbstractHostBehavior;
import de.fxdiagram.core.behavior.Behavior;
import de.fxdiagram.core.behavior.NavigationBehavior;
import de.fxdiagram.examples.slides.ClickThroughSlide;

@SuppressWarnings("all")
public class RevealBehavior extends AbstractHostBehavior<ClickThroughSlide> implements NavigationBehavior {
  public RevealBehavior(final ClickThroughSlide slide) {
    super(slide);
  }
  
  protected void doActivate() {
  }
  
  public Class<? extends Behavior> getBehaviorKey() {
    return NavigationBehavior.class;
  }
  
  public boolean next() {
    ClickThroughSlide _host = this.getHost();
    boolean _next = _host.next();
    return _next;
  }
  
  public boolean previous() {
    ClickThroughSlide _host = this.getHost();
    boolean _previous = _host.previous();
    return _previous;
  }
}