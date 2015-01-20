/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.faces.systest.model.ajax;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.faces.context.ExternalContext;
import javax.faces.FacesException;

@ManagedBean
@RequestScoped
public class InsertDeleteBean {

    public String insertBefore() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        if (ctx.getPartialViewContext().isAjaxRequest()) {
            try {
                extContext.setResponseContentType("text/xml");
                extContext.addResponseHeader("Cache-Control", "no-cache");
                PartialResponseWriter writer =
                      ctx.getPartialViewContext().getPartialResponseWriter();
                writer.startDocument();
                
                writer.startInsertBefore("hr");
                writer.writeAttribute("id", "h2before", "id");
                writer.startElement("h2", null);
                writer.writeText("BEFORE", null, null);
                writer.endElement("h2");
                writer.endInsert();
                
                writer.startInsertBefore("tablecenter");
                writer.writeAttribute("id", "trbefore", "id");
                writer.startElement("tr", null);
                writer.writeAttribute("id", "trbefore", "id");
                writer.startElement("td", null);
                writer.writeText("BEFORE", null, null);
                writer.endElement("td");
                writer.endElement("tr");
                writer.endInsert();
                
                writer.endDocument();
                writer.flush();
                ctx.responseComplete();
            } catch (Exception e) {
                throw new FacesException(e);
            }
        }
        return null;

    }

    public String insertAfter() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        if (ctx.getPartialViewContext().isAjaxRequest()) {
            try {
                PartialResponseWriter writer =
                      ctx.getPartialViewContext().getPartialResponseWriter();
                extContext.setResponseContentType("text/xml");
                extContext.addResponseHeader("Cache-Control", "no-cache");
                writer.startDocument();

                writer.startInsertAfter("hr");
                writer.startElement("h2", null);
                writer.writeAttribute("id", "h2after", "id");
                writer.writeText("AFTER", null, null);
                writer.endElement("h2");
                writer.endInsert();

                writer.startInsertAfter("tablecenter");
                writer.writeAttribute("id", "trafter", "id");
                writer.startElement("tr", null);
                writer.writeAttribute("id", "trafter", "id");
                writer.startElement("td", null);
                writer.writeText("AFTER", null, null);
                writer.endElement("td");
                writer.endElement("tr");
                writer.endInsert();

                writer.endDocument();
                writer.flush();
                ctx.responseComplete();
            } catch (Exception e) {
                throw new FacesException(e);
            }
        }
        return null;

    }


    public String removeBefore() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        if (ctx.getPartialViewContext().isAjaxRequest()) {
            try {
                PartialResponseWriter writer =
                      ctx.getPartialViewContext().getPartialResponseWriter();
                extContext.setResponseContentType("text/xml");
                extContext.addResponseHeader("Cache-Control", "no-cache");
                writer.startDocument();
                writer.delete("h2before");
                writer.delete("trbefore");
                writer.endDocument();
                writer.flush();
                ctx.responseComplete();
            } catch (Exception e) {
                throw new FacesException(e);
            }
        }
        return null;

    }

    public String removeAfter() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        if (ctx.getPartialViewContext().isAjaxRequest()) {
            try {
                PartialResponseWriter writer =
                      ctx.getPartialViewContext().getPartialResponseWriter();
                extContext.setResponseContentType("text/xml");
                extContext.addResponseHeader("Cache-Control", "no-cache");
                writer.startDocument();
                writer.delete("h2after");
                writer.delete("trafter");
                writer.endDocument();
                writer.flush();
                ctx.responseComplete();
            } catch (Exception e) {
                throw new FacesException(e);
            }
        }
        return null;    
    }

}
