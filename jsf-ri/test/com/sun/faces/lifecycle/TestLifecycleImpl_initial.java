/*
 * $Id: TestLifecycleImpl_initial.java,v 1.7 2002/07/13 01:21:56 eburns Exp $
 */

/*
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

// TestLifecycleImpl_initial.java

package com.sun.faces.lifecycle;

import org.apache.cactus.WebRequest;


import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.Phase;
import javax.faces.context.FacesContext;

import com.sun.faces.RIConstants;

import com.sun.faces.JspFacesTestCase;

/**
 *
 *  <B>TestLifecycleImpl_initial</B> is a class ...
 *
 * <B>Lifetime And Scope</B> <P>
 *
 * @version $Id: TestLifecycleImpl_initial.java,v 1.7 2002/07/13 01:21:56 eburns Exp $
 * 
 * @see	Blah
 * @see	Bloo
 *
 */

public class TestLifecycleImpl_initial extends JspFacesTestCase
{
//
// Protected Constants
//

public static final String TEST_URI = "/components.jsp";

public String getExpectedOutputFilename() {
    return "TestLifecycleImpl_initial_correct";
}

public static final String ignore[] = {
    "<form method=\"post\" action=\"%2Ftest%2Ffaces%2Fform%2FbasicForm%2F%252Fcomponents.jsp;jsessionid=151570B338F444B3F451B049396260F0\">"
};

public String [] getLinesToIgnore() {
    return ignore;
}

public boolean sendResponseToFile() 
{
    return true;
}

//
// Class Variables
//

//
// Instance Variables
//

// Attribute Instance Variables

// Relationship Instance Variables

//
// Constructors and Initializers    
//

    public TestLifecycleImpl_initial() {super("TestLifecycleImpl_initial");}
    public TestLifecycleImpl_initial(String name) {super(name);}

//
// Class methods
//

//
// General Methods
//


protected void initWebRequest(WebRequest theRequest)
{
    theRequest.setURL("localhost:8080", null, null, TEST_URI, null);
}

public void beginExecuteInitial(WebRequest theRequest)
{
    initWebRequest(theRequest);
}

public void testExecuteInitial()
{
    boolean result = false;
    LifecycleImpl life = new LifecycleImpl();

    try {
	life.execute(getFacesContext());
    }
    catch (Throwable e) {
	e.printStackTrace();
	assertTrue(e.getMessage(), false);
    }

    assertTrue(verifyExpectedOutput());

}



} // end of class TestLifecycleImpl_initial
