package asteroides.examples.org.asteroides;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Vespertino on 22/11/2017.
 */

public class Grafico {
    private Drawable drawable;   //Imagen que dibujaremos
    private int cenX, cenY;      //Posición del centro del grafico
    private int ancho, alto;     //Dimensiones de la imagen
    private double incX, incY;  //Velocidad de desplazamiento
    private double angulo, rotacion; //Angulo y velocidad de rotacion
    private int radioColision; //Para determinar colisión
    private int xAnterior, yAnterior; //Posicion Anterior
    private int radioInval;     //Radio usado en invalidate()
    private View view;          //Usuada en view.invalidate()

    public Grafico(Drawable drawable, View view) {
        this.drawable = drawable;
        this.view = view;

        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto+ancho)/4;
        radioInval =(int)Math.hypot(ancho/2,alto/2);
    }

    public void dibujarGrafico(Canvas canvas){
        int x = cenX - ancho/2;
        int y = cenY - alto/2;

        drawable.setBounds(x,y,x+ancho, y+alto);
        canvas.save();
        canvas.rotate((float)angulo, cenX, cenY);
        drawable.draw(canvas);
        canvas.restore();

        view.invalidate(cenX-radioInval, cenY-radioInval, cenX+radioInval,cenY+radioInval);
        view.invalidate(xAnterior-radioInval,yAnterior-radioInval, xAnterior+radioInval, yAnterior+radioInval);

        xAnterior = cenX;
        yAnterior = cenY;
    }

    public void incrementaPos (double factor){
        cenX += incX * factor;
        cenY += incY * factor;
        angulo += rotacion * factor;

        //Si salimos de la pantalla, coregimos posicion


    }
}
