package com.jiajia.config;
/*    */
/*    */

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/*    */
/*    */
/*    */
/*    */

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ class CasFilterChain implements FilterChain {
/*    */    private ServletRequest request;
/*    */    private ServletResponse response;
/*    */    private boolean iscontinue = false;
/*    */
/*    */    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
/* 23 */       this.iscontinue = true;
/* 24 */       this.request = request;
/* 25 */       this.response = response;
/* 26 */    }
/*    */
/*    */    public void reset() {
/* 29 */       this.iscontinue = false;
/* 30 */    }
/*    */
/*    */    public ServletRequest getRequest() {
/* 33 */       return this.request;
/*    */    }
/*    */
/*    */    public ServletResponse getResponse() {
/* 37 */       return this.response;
/*    */    }
/*    */
/*    */    public boolean isContinue() {
/* 41 */       return this.iscontinue;
/*    */    }
/*    */ }