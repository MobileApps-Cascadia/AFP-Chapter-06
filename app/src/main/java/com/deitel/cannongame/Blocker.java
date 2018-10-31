// Blocker.java
// Subclass of GameElement customized for the Blocker
package com.deitel.cannongame;

public class Blocker extends GameElement {
   private int missPenalty; // the miss penalty for this Blocker
   private int blockerSoundId;

   // constructor
   public Blocker(CannonView view, int color, int missPenalty, int x,
      int y, int width, int length, float velocityY) {

      super(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length,
         velocityY);
      blockerSoundId = CannonView.BOUNCE_SOUND_ID;
      this.missPenalty = missPenalty;

   }


   @Override
   public void update(double interval) {
      // if this GameElement collides with the wall, reverse direction

      if (shape.top < 0 || shape.bottom  > view.getScreenHeight()) {
         view.playSound(blockerSoundId);
      }

      super.update(interval);
   }




   // returns the miss penalty for this Blocker
   public int getMissPenalty() {
      //view.playSound(blockerSoundId);
      return missPenalty;
   }
}

/*********************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and * Pearson Education, *
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this   *
 * book have used their * best efforts in preparing the book. These efforts      *
 * include the * development, research, and testing of the theories and programs *
 * * to determine their effectiveness. The authors and publisher make * no       *
 * warranty of any kind, expressed or implied, with regard to these * programs   *
 * or to the documentation contained in these books. The authors * and publisher *
 * shall not be liable in any event for incidental or * consequential damages in *
 * connection with, or arising out of, the * furnishing, performance, or use of  *
 * these programs.                                                               *
 *********************************************************************************/
