public class Container implements Comparable<Container> {
    
    private String ID;
    private String shortName;
    private String longName;
    
    public String getID(){
        return ID;
    }
    
    public void setID(String ID){
        this.ID=ID;
    }
    
    public String getShortname(){
        return shortName;
    }
    
    public void setShortname(String shortName){
        this.shortName=shortName;
    }
    
    public String getLongname(){
        return longName;
    }
    
    public void setLongname(String longName){
        this.longName=longName;
    }
    
    @Override
    public String toString(){
      return "  <CONTAINER " + this.getID() + ">\n"
              +"    <SHORT-NAME>" + this.getShortname() + "</SHORT-NAME>\n"
              +"    <LONG-NAME>" + this.getLongname() + "</LONG-NAME>\n"
              +"  </CONTAINER>\n";
    }
    
    @Override
    public int compareTo(Container o){
        return this.getShortname().compareTo(o.getShortname());
    }
}
