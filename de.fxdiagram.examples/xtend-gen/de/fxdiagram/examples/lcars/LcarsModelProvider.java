package de.fxdiagram.examples.lcars;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.model.DomainObjectHandle;
import de.fxdiagram.core.model.DomainObjectProvider;
import de.fxdiagram.core.model.ModelElement;
import de.fxdiagram.examples.lcars.LcarsConnectionHandle;
import de.fxdiagram.examples.lcars.LcarsEntryHandle;
import java.util.List;
import org.bson.types.ObjectId;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ModelNode
@SuppressWarnings("all")
public class LcarsModelProvider implements DomainObjectProvider {
  private DB db;
  
  private DBCollection lcars;
  
  public LcarsModelProvider() {
    try {
      final Mongo mongo = new Mongo();
      DB _dB = mongo.getDB("startrek");
      this.db = _dB;
      DBCollection _collection = this.db.getCollection("lcars");
      this.lcars = _collection;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<DBObject> query(final String fieldName, final Object fieldValue) {
    BasicDBObject _basicDBObject = new BasicDBObject();
    final Procedure1<BasicDBObject> _function = new Procedure1<BasicDBObject>() {
      public void apply(final BasicDBObject it) {
        it.put(fieldName, fieldValue);
      }
    };
    BasicDBObject _doubleArrow = ObjectExtensions.<BasicDBObject>operator_doubleArrow(_basicDBObject, _function);
    DBCursor _find = this.lcars.find(_doubleArrow);
    return IterableExtensions.<DBObject>toList(((Iterable<DBObject>) _find));
  }
  
  public Object resolveDomainObject(final DomainObjectHandle handle) {
    BasicDBObject _basicDBObject = new BasicDBObject();
    final Procedure1<BasicDBObject> _function = new Procedure1<BasicDBObject>() {
      public void apply(final BasicDBObject it) {
        String _id = handle.getId();
        ObjectId _objectId = new ObjectId(_id);
        it.put("_id", _objectId);
      }
    };
    BasicDBObject _doubleArrow = ObjectExtensions.<BasicDBObject>operator_doubleArrow(_basicDBObject, _function);
    return this.lcars.findOne(_doubleArrow);
  }
  
  public DomainObjectHandle createDomainObjectHandle(final Object it) {
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof DBObject) {
        _matched=true;
        return this.createLcarsEntryHandle(((DBObject)it));
      }
    }
    if (!_matched) {
      if (it instanceof String) {
        _matched=true;
        return this.createLcarsConnectionHandle(((String)it));
      }
    }
    throw new IllegalArgumentException("LcarsModelProvider only knows about DBObjects");
  }
  
  public LcarsEntryHandle createLcarsEntryHandle(final DBObject it) {
    Object _get = it.get("_id");
    String _string = _get.toString();
    Object _get_1 = it.get("name");
    String _string_1 = _get_1.toString();
    return new LcarsEntryHandle(_string, _string_1, this);
  }
  
  public LcarsConnectionHandle createLcarsConnectionHandle(final String fieldName) {
    return new LcarsConnectionHandle(fieldName, this);
  }
  
  public void populate(final ModelElement modelElement) {
    
  }
}