



public class CompetetiveSwimmer extends Member{
   Kontingent CreateK = new Kontingent();
   public void kontingent(){
   
      if (super.getAge() < 18){
         CreateK.getKontingentJunior();
      }
      else if (super.getAge() > 18 && getAge() <60){
         CreateK.getKontingentSenior();
      }
      else{
      CreateK.getKontingentPension();
      }
   
   }

}
