package src;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;

public class MyFileList {

		public static void main(String[] args) {
//			List Directories<> = new ArrayList<>();
			ArrayList Directories = new ArrayList<>();
			ArrayList MyFiles = new ArrayList<>();
			File myFile;
			System.out.println(args[0]);
			myFile = new File(args[0]);
			File[] files = myFile.listFiles();
			for(File f: files) {
//				System.out.println(f.toString() + "  " + f.getAbsolutePath() + " is directory " + f.isDirectory());
				if (f.isDirectory() == true)
				 {
					Directories.add(f);
					
				 }
				if (f.isFile() == true)
				 {
					MyFiles.add(f);
				 }
			}
			System.out.println("Files are: " + MyFiles.size());
			System.out.println("Directories are: " + Directories.size());
			
		}
	}



/*
package mux;
import java.io.*;
import java.lang.String;
import java.sql.*;

public class MusicFile
{
  
  public static Connection conn;
  public static File myMusic;
  public static String MUSICDB;
  public static String USER;
  public static String PASSWD;

    public MusicFile() {
    }
    
public static void main(String[] args)
{
  File myMusic = new File(args[0]);
  String MUSICDB = args[1];
  String USER = args[2];
  String PASSWD = args[3];
  int Trys = 0;
    
 if (args.length == 4)
 {
  //System.out.println(args[0]);
  
  
  System.out.println ("DB is " + MUSICDB + "User is " + USER + "PASSWD is " + PASSWD);
      
  String data = ("jdbc:odbc:" + MUSICDB);
   try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       conn = DriverManager.getConnection(data,USER,PASSWD);
      }  catch (Exception e)
     {  
      // System.out.println("Query Error"); 
       System.out.println("Error - " + e.toString());
     }
        
//Create object that is a Directory
      
 System.out.println(myMusic + (myMusic.isDirectory()?" is ": "is not ") + "a direcotry");

  //Create File object
        
File[] Genre = myMusic.listFiles();
if(Genre != null)
{  //System.out.println("Reached contents not null");
           
   // this section takes the path and identifies directiries as genre types
for (int i = 0; i < Genre.length; i++)
{ //System.out.println("For loop 1 of contents not null");
      //String A = toString(contents[i].isDirectory());
	 
 if (Genre[i].isDirectory() == true)
 {
    String Genre_Path = Genre[i].getPath();
    String Genre_Name = Genre[i].getName();
    System.out.println("Genre is " + Genre_Name);
 //start Genre information 
    QueryGenre myGenre = new QueryGenre(Genre_Name,conn );
    int Genre_Id = myGenre.ID;
    int Genre_trys = 0;
    System.out.println("FIRST Genre_Id is " + Genre_Id);
    if(Genre_Id > 0)
     {    
      System.out.println("Genre_Id is found and is " + Genre_Id);
      }
     else
     {
       System.out.println("Genre_Id is not found and is " + Genre_Id);
       while ((Genre_Id < 1)&& (Genre_trys < 1))
       {
         System.out.println("Genre_Name is" + Genre_Name + "and ID is " + Genre_Id);
         GenreSQL insertGen = new GenreSQL(Genre_Name,conn);
         QueryGenre nextAttempt = new QueryGenre(Genre_Name,conn);
         Genre_Id = nextAttempt.ID;
         Genre_trys ++;
         System.out.println("Tries = "+ Genre_trys);
        }
       System.out.println("Genre_Id is    NOW   " + Genre_Id);
      }
    System.out.println("Start Artist_Name");
 // start Artist     
    File Artist = new File(Genre_Path);
    File[] Artist_Name = Artist.listFiles();
    
    if(Artist_Name != null)
    {
     //System.out.println("Starting next directory");
     for (int j = 0; j < Artist_Name.length; j++)
      {
        if ((Artist_Name[j].isHidden() == false)&& (Artist_Name[j].isDirectory() == true))
        {  
         int Art_trys = 0; 
         String Art_name = Artist_Name[j].getName();
         String Art_Path = Artist_Name[j].getPath();
         System.out.println("Artist is " + Art_name);
//Start Musicain information
//QueryArtist
         QueryArtist thisArtist = new QueryArtist(Art_name,conn);
         int Art_Id = thisArtist.ID;
         if(Art_Id > 0)
         {    
           System.out.println("Art_Id is found and is " + Art_Id);
          }
         else
         {
          System.out.println("Art_Id is not found and is " + Art_Id);
          while((Art_Id < 1)&&(Art_trys < 1))
          {
           System.out.println("Artist_Name is" + Art_name + "and ID is " + Art_Id);
//Insert Artist    
           ArtistSQL insertArtist = new ArtistSQL(Art_name,conn);
           QueryArtist nextAttempt = new QueryArtist(Art_name,conn);
           Art_Id = nextAttempt.ID;
           Art_trys ++;
           System.out.println("Tries = "+ Art_trys);
          }
           System.out.println("Art_Id is    NOW   " + Art_Id);
          }
 // Finish insert Musician information
     File Album = new File(Art_Path);
     File[] Album_Name = Album.listFiles();
     if(Album_Name != null)
       {
        for (int k = 0; k < Album_Name.length; k++)
        {
         if ((Album_Name[k].isHidden() == false)&& (Album_Name[k].isDirectory() == true))
         {   
            String Alb_name = Album_Name[k].getName();
            String Alb_Path = Album_Name[k].getPath();
            System.out.println("Album is " + Alb_name);
            System.out.println("Album Path is " + Alb_Path);
                                 
 // Start insert Album information                                   
            queryAlbum thisAlbum = new queryAlbum(Alb_name,conn);
            int Album_Id = thisAlbum.ID;
            int Album_trys = 0;
            if(Album_Id > 0)
            {    
             System.out.println("Album_Id is found and is " + Album_Id);
             if (thisAlbum.GEN != Genre_Id)
             {
              System.out.println("DB Album Genre is " + thisAlbum.GEN + "Genre is "+ Genre_Id);
              while (Album_trys < 3)
              {
               updateAlbum theAlbum = new updateAlbum(Album_Id, Genre_Id, conn);
               if(theAlbum.upDate == true)
               {
                Album_trys = 3;
               }
               else 
               {
                Album_trys ++;
                }
              }
             }
            }
         else
         {
           System.out.println("Album_Id is not found and is " + Album_Id);
           while ((Album_Id < 1))
            {
            System.out.println("Album_Name is" + Alb_name + "and ID is " + Album_Id);
            AlbumSQL insertGen = new AlbumSQL(Alb_name,Genre_Id,Art_Id, conn);
            queryAlbum nextAttempt = new queryAlbum(Alb_name, conn);
            Album_Id = nextAttempt.ID;
            Album_trys ++;
            System.out.println("Tries = "+ Album_trys);
            }
           if(Album_Id < 0)
            {
             Album_Id = 99;
             }
          }
         System.out.println("Album_Id is    NOW   " + Album_Id);                                
                                    
  //  Finsish insert Album information                                  
         File Song = new File(Alb_Path);
         File[] Song_Names = Song.listFiles();
         if(Song_Names != null)
         {
          for (int l = 0; l < Song_Names.length; l++)
          {
           if ((Song_Names[l].isHidden() == false)&& (Song_Names[l].isDirectory() == false))
           {   
             String Song_Name = Song_Names[l].getName();
             String Song_Path = Song_Names[l].getPath();
             System.out.println(Song_Name);
 //Start Insert Song                                                   
             SongObject thisSong = new SongObject();
             thisSong.Song(Song_Name,Song_Path,Album_Id,Genre_Id, Art_Id,conn);
             thisSong.querySong(Song_Name,Song_Path,Album_Id,Genre_Id, Art_Id,conn);
             int Song_trys = 0;
             if(thisSong.AlreadyExist == true)
             {    
               System.out.println("Song " + Song_Name + "already exist");
               if(thisSong.upDate == true)
               {
                System.out.println("Song " + Song_Name + "was updated");  
                }
             }
             else
             {
              System.out.println(Song_Name + " is not found");
               while ((thisSong.insertSuccess == false) && (Song_trys < 3))
               {
                thisSong.insertSong(Song_Name,Song_Path,Album_Id,Genre_Id, Art_Id,conn);
                Song_trys ++;
                System.out.println("Tries = "+ Song_trys);
                }
               if ((Song_trys == 3) && (thisSong.insertSuccess == false))
               {    
                System.out.println("SONG " + Song_Name + " IS NOT INSERTED");
                if (thisSong.insertSuccess == true)
                {
                 System.out.println("SONG " + Song_Name + " IS INSERTED");
                 }
                }
               }
           }
          }
         } //Song_Names != null
        }
       }//for Album_Name.length
      }//Album_Name != null
     }//Artist_Name[j].isHidden
    } //for Artist_Name.length
   }//if(Artist_Name
  } //if Genre[i].isDirectory
//------- everything happens before this ----------
  else 
   {
     if (Genre[i].isHidden() == false)
     {    
      System.out.println("Reached esle statement");
      System.out.println(Genre[i] + "  " +(Genre[i].isDirectory() ? "directory" : "file"));
     }
    }
   }//for (int i = 0; i < Genre.length; i++)
 }//if(Genre != null)
}//if (args.length == 4)
if (args.length < 4)
   { System.out.println("Syntax is musicFile <directory path> <Database> <DB UUID> <DB Passwd>");
    }
   return;
  }//void main
}//class MusicFile

*/