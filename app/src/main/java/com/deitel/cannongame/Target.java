// Target.java
// Subclass of GameElement customized for the Target
package com.deitel.cannongame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;

public class Target extends GameElement {
   private int hitReward; // the hit reward for this target
   private Bitmap bitmap;

   // constructor
   public Target(CannonView view, BitmapDrawable bitmap, int hitReward, int x, int y,
                 int width, int length, float velocityY) {
      super(view, Color.TRANSPARENT, CannonView.TARGET_SOUND_ID, x, y, width, length,
         velocityY);
      this.hitReward = hitReward;
      this.bitmap = bitmap.getBitmap();
   }

   @Override
   public void draw(Canvas canvas) {
      canvas.drawBitmap(bitmap, null, shape, paint);
   }

   // returns the hit reward for this Target
   public int getHitReward() {
      return hitReward;
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
