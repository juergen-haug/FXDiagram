package de.fxdiagram.eclipse.mapping;

import de.fxdiagram.core.model.DomainObjectProvider;
import de.fxdiagram.eclipse.mapping.AbstractMapping;
import de.fxdiagram.eclipse.mapping.IMappedElementDescriptor;

@SuppressWarnings("all")
public interface IMappedElementDescriptorProvider extends DomainObjectProvider {
  public abstract <T extends Object> IMappedElementDescriptor<T> createMappedElementDescriptor(final T domainObject, final AbstractMapping<T> mapping);
}