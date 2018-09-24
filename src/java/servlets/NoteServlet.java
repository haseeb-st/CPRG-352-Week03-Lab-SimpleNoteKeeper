/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 687159
 */
public class NoteServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = br.readLine();
        String content = br.readLine();
        
        Note note = new Note(title, content);
               
        if(request.getParameter("edit") !=null)
        {
            request.setAttribute("note", note);
            br.close(); 
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        
        request.setAttribute("note", note);
        br.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(path, false));
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");    
        
        pw.println(title);
        pw.write(content);

        Note note = new Note(title, content);
        request.setAttribute("note", note);

        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
