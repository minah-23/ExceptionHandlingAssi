
import java.util.*;
import java.io.*;

public class Assig6 {

    
    public static void main(String[] args) {
        
try{        
            String filen = args[0];
            //"test.arxml";
            
            if(!filen.endsWith(".arxml")){
                throw new NotValidAutosarFileException("Invalid file extension");
            }
            
            File file = new File(filen);
            FileReader inputS = new FileReader(file);

            if (file.length()==0){
                throw new EmptyAutosarFileException("Empty File");
            }


            int n;
            StringBuilder st = new StringBuilder();
            
            while((n=inputS.read()) != -1){
                st.append((char)n);
            }

            inputS.close();
            
            String data = st.toString();
            Scanner scan = new Scanner(data);
            ArrayList<Container> containers = new ArrayList<Container>();
            
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.contains("<CONTAINER")){
                    String ID = line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    
                    String shortname = scan.nextLine();
                    String sh = shortname.substring(shortname.indexOf(">")+1,shortname.indexOf("</"));
                    
                    String longname = scan.nextLine();
                    String ln = longname.substring(longname.indexOf(">")+1, longname.indexOf("</"));
                    
                    Container c =new Container();
                    c.setID(ID);
                    c.setShortname(sh);
                    c.setLongname(ln);
                    containers.add(c);
                }
            }
            
            Collections.sort(containers);
            
            String outname = args[0].substring(0,filen.indexOf(".")) + "_mod.arxml";
            FileOutputStream output = new FileOutputStream(outname);
            output.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            output.write("<AUTOSAR>\n".getBytes());
            
            for(int i=0 ; i<containers.size();i++ ){
                output.write(containers.get(i).toString().getBytes());
            }
            
            output.write("</AUTOSAR>\n".getBytes());
            
        }
        
        catch(FileNotFoundException e){
            e = new FileNotFoundException("File not found");
        }
        
        catch(IOException e){
            e = new IOException("IO Exception");
        }
        
        catch(NotValidAutosarFileException e){
            System.out.println("Invalid Extension");
        }

        catch(EmptyAutosarFileException e){
            System.out.println("Emtpy File");
        }

    }
    
}


class NotValidAutosarFileException extends Exception{
    NotValidAutosarFileException(String m){
        super(m);
    }
}

class EmptyAutosarFileException extends Error {
    EmptyAutosarFileException(String m){
        super(m);
    }
}    
    

