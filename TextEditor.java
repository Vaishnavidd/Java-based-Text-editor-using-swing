import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class TextEditor extends JFrame implements ActionListener
{
    JTextArea text;
    JMenuBar MB;
    JMenu FILE,EDIT;
    JMenuItem FILENEW,FILEOPEN,FILESAVE,FILESAVEAS,FILEEXIT;
    JMenuItem EDITCOPY,EDITCUT,EDITPASTE;
	JMenuItem FONT;
    JFileChooser jf;
    boolean opened=false;
    String filename;
	int fontsize;
	Color fontcolor;
	String fontname;
	int fontstyle;
    public TextEditor()
    {
        this.setTitle("editor");
      text=new JTextArea(0,0);
       MB=new JMenuBar();
       FILE=new JMenu("File");
       EDIT=new JMenu("Edit");
       FILENEW = new JMenuItem("New");
       FILEOPEN= new JMenuItem("Open");
       FILESAVE= new JMenuItem("Save");
	   FILESAVEAS= new JMenuItem("Save AS");
       FILEEXIT= new JMenuItem("Exit");
       EDITCOPY = new JMenuItem("Copy");
       EDITCUT= new JMenuItem("Cut");
       EDITPASTE= new JMenuItem("Paste");
       FILE.add(FILENEW);
       FILE.add(FILEOPEN);
       FILE.add(FILESAVE);
	   FILE.add(FILESAVEAS);
       FILE.add(FILEEXIT);
       EDIT.add(EDITCOPY);
       EDIT.add(EDITCUT);
       EDIT.add(EDITPASTE);
	   FONT= new JMenuItem("Font");
       MB.add(FILE);
       MB.add(EDIT);
	   MB.add(FONT);
       EDITCOPY.addActionListener(this);
       EDITCUT.addActionListener(this);
       EDITPASTE.addActionListener(this);
       FILENEW.addActionListener(this);
       FILEOPEN.addActionListener(this);
       FILESAVE.addActionListener(this);
	   FILESAVEAS.addActionListener(this);
       FILEEXIT.addActionListener(this);
	   FONT.addActionListener(this);
       setJMenuBar(MB);
       setSize(600,600);
       add(text,BorderLayout.CENTER);
       setVisible(true);
   }
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==FILENEW)
      {
       text.setText("");
       opened=false;
      }
      else if(e.getSource()==FILEOPEN)
      {
         text.setText(null);
          jf=new JFileChooser();
         jf.showOpenDialog(new JPanel());
         filename=String.valueOf(jf.getSelectedFile());
         opened=true;
         String s;
         FileReader r;
         BufferedReader b;
         try
         {
             r=new FileReader(filename);
             b=new BufferedReader(r);
             while((s=b.readLine())!=null)
             {
                text.append(s);
                text.append("\n");
             }
              b.close();
              r.close();
         }
         catch(Exception e1)
         {
           System.out.println(e1);
         }
     }
     else if(e.getSource()==FILESAVE)
     {
        if(opened==true)
        {
            try
             {
               FileWriter fw=new FileWriter(filename);
               fw.write(text.getText());
               fw.close();
             }
             catch(Exception e1)
             {
              System.out.println(e1);
             }
         }
          else
         {
            JFileChooser jfc=new JFileChooser();
            jfc.showSaveDialog(new JPanel());
            filename=String.valueOf(jfc.getSelectedFile());
            try
            {
               FileWriter fr=new FileWriter(filename);
               fr.write(text.getText());
               fr.close();
             }
             catch(Exception e1)
             {
              System.out.println(e1);
             }
         }
      }
	  else if(e.getSource()==FILESAVEAS)
	  {

            JFileChooser jfc=new JFileChooser();
            jfc.showSaveDialog(new JPanel());
            filename=String.valueOf(jfc.getSelectedFile());
            try
            {
               FileWriter fr=new FileWriter(filename);
               fr.write(text.getText());
               fr.close();
             }
             catch(Exception e1)
             {
              System.out.println(e1);
             }




	  }
      else if(e.getSource()==EDITCOPY)
       {
          text.copy();
       }
       else if(e.getSource()==EDITCUT)
       {
          text.cut();
       }
       else if(e.getSource()==EDITPASTE)
       {
          text.paste();
       }
	   else if(e.getSource()==FONT)
       {
          fontchooser ff=new fontchooser(this);
		 // JOptionPane.showMessageDialog(null,"FontName:"+fontname);

       }
      else if(e.getSource()==FILEEXIT)
      {
      System.exit(0);
      }
    }//end actionPerformed
    public static void main(String args[])
    {
      TextEditor p=new TextEditor();
p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//end main
 }//end class





