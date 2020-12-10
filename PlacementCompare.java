// Class to compare Competitions
import java.util.*;
public class PlacementCompare implements Comparator<Competition> 
{ 
    public int compare(Competition m1, Competition m2) 
    { 
        if (m1.placement < m2.placement) return -1; 
        if (m1.placement > m2.placement) return 1; 
        else return 0; 
    } 
}