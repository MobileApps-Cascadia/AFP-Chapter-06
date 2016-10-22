// Cannonball.java
// Represents the Cannonball that the Cannon fires
package com.deitel.cannongame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;

import static android.R.attr.radius;

public class Cannonball extends GameElement {
   private float velocityX;
   private boolean onScreen;
   private Matrix matrix;
   private Bitmap bitmap;

   // constructor
   public Cannonball(CannonView view, Bitmap bitmap, int soundId, int x,
                     int y, int radius, float velocityX, float velocityY, double angle) {
      super(view, Color.WHITE, soundId, x, y,
         2 * radius, 2 * radius, velocityY);
      this.bitmap = bitmap;

      this.velocityX = velocityX;
      onScreen = true;
      // adjust shape size to keep bitmap in proportion
      double aspectRatio = (double) bitmap.getWidth() / (double) bitmap.getHeight();
      if (bitmap.getWidth() > bitmap.getHeight()) {
         int width = (int) (aspectRatio / radius);
         shape.right = shape.left + width;
      }
      else if (bitmap.getWidth() < bitmap.getHeight()) {
         int height = (int) (radius / aspectRatio);
         shape.bottom = shape.top + height;
      }
      float width = (float) radius * 2;
      float scale = Math.max(width / (float)bitmap.getWidth(), width / (float)bitmap.getHeight());
      // Create matrix and rotate to match angle
      matrix = new Matrix(); // default is identity matrix
      // add resize to matrix
      matrix.setScale(scale, scale);
      // Rotate the matrix about the center
      matrix.postRotate((float)angle, radius, radius);
      // move the matrix to the start position
      matrix.postTranslate(x, y);
   }

   // test whether Cannonball collides with the given GameElement
   public boolean collidesWith(GameElement element) {
      return (Rect.intersects(shape, element.shape) && velocityX > 0);
   }

   // returns true if this Cannonball is on the screen
   public boolean isOnScreen() {
      return onScreen;
   }

   // reverses the Cannonball's horizontal velocity
   public void reverseVelocityX() {
      velocityX *= -1;
   }

   // updates the Cannonball's position
   @Override
   public void update(double interval) {
      super.update(interval); // updates Cannonball's vertical position

      matrix.postTranslate(velocityX * (float)interval, velocityY * (float)interval);

      // update horizontal position
      shape.offset((int) (velocityX * interval), 0);

      // if Cannonball goes off the screen
      if ((shape.top < 0 || shape.left < 0) ||
             (shape.bottom > view.getScreenHeight() ||
              shape.right > view.getScreenWidth())) {
         onScreen = false; // set it to be removed
   }
    }
   // draws the Cannonball on the given canvas
   @Override
   public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, matrix, paint);
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
