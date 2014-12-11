/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sit.int303.spe.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author INT303
 */
public class AuthenticationFilter implements Filter {
    FilterConfig config ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig ;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession s = ((HttpServletRequest) request).getSession();
        HttpServletResponse rp = (HttpServletResponse) response;
        String uri = ((HttpServletRequest) request ).getRequestURI() ;
        System.out.println("uri before: "+ uri);
        uri = uri.substring(uri.indexOf("/", 1));
        System.out.println("uri after: "+ uri);
        uri = rp.encodeURL("/Login?destination="+uri);
        if (s.getAttribute("user")==null) {
            config.getServletContext().getRequestDispatcher(uri).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
        
    }

    @Override
    public void destroy() {
    }
    
}
