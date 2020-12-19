package edu.wofford.machiwoco;


/** 
 * This class is an extension of the Card class.
 * It contains particular cards that players can collect throughout the game.
 */
public class LandMark extends Card{
    protected boolean built;
    protected String name;

/**
* The compnents from this method are assosicated from the super parent class.
* @param name The name of the landmark.
*/
    public LandMark(String name){
        super(name);
        icon = "T";
        color = "N";
        built = false;
    }
/** 
 * This method checks to see if the LandMark has not been built.
 * @return This will return false.
 */
    public boolean isBuilt(){
        return built;
    }
/** 
 * This method will check if the LandMark is built.
 * It will return built as true showing LandMark.
 */
    public void setBuilt(){
        built = true;
    }
/**
 * This method overrides the equal method so that the LandMark cards can be compared.
 * @param o Is the object that is being compared.
 * @return  This returns the name of the LandMark card.
 * @return false
 */
    @Override
    public boolean equals(Object o){
        if(o instanceof LandMark){
            LandMark l = (LandMark)o;
            return name == l.name;
        }
        return false;
    }
}