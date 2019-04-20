import java.io.*;  // input output package

class DirectoryLister
{
   public static void main(String args[])
     {
	 File entry;  // variable named entry of type File holder for File object type
	 if (args.length == 0)
	  { 
		System.err.println("Provide specific directory name.");
	  	return;
	  }
	entry = new File(args[0]);  // argument provided

// implement class listDirectory
	listDirectory(entry);  // method call 
      } 

// Define class listDirectory

  public static void listDirectory(File entry)
    {
	  int fileCount = 0;
	try{
		 if (!entry.exists())
		  {
			 
			System.out.println(entry.getName() + "not found");
			
			return;
		  }

		if (entry.isFile())
		{	
		  System.out.println(entry.getCanonicalPath() + "   "  + entry.lastModified()); 
		}  else if (entry.isDirectory())
		    {
			   String fileName[] = entry.list();
			   System.out.println(fileName.length);
			if (fileName == null)  return;

		    for (int i = 0; i < fileName.length; i++)
			{
			  File item = new File(entry.getPath(), fileName[i]);
			  listDirectory(item);
			}
		    }
	   } catch(IOException e) { System.out.println("Error  " + e);}
   }
}