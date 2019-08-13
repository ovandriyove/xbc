package xbc.web;

import javax.swing.text.Document;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import xbc.model.AuditLog;
//import xbc.model.Category;
//import xbc.model.DocumentTestDetail;
//import xbc.model.Question;
//import xbc.model.Role;
//import xbc.model.Test;
//import xbc.model.TestType;
//import xbc.model.User;

public class IgnoranceIntrospector extends JacksonAnnotationIntrospector {
//    public boolean hasIgnoreMarker(AnnotatedMember m) {
//        boolean result = false;
//
//        if (m.getRawType() == AuditLog.class || 
//        	m.getRawType() == Menu.class ||
//        	m.getRawType() == Biodata.class ||
//        	m.getRawType() == Trainer.class ||
//        	m.getRawType() == Technology.class ||
//        	m.getRawType() == Role.class ||
//        	m.getRawType() == TechnologyTrainer.class ||
//        	m.getRawType() == Batch.class ||
//        	m.getRawType() == User.class ||
//			m.getRawType() == Clazz.class
//        	) {
//        	result = true;
//        }
//
//    	return result || super.hasIgnoreMarker(m);
//    }
} 