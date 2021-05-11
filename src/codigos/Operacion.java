
package codigos;

import Interfaz.VentanaPrincipal;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joseph
 */
public class Operacion {
    
    public static final int RED = 1;
    public static final int GREEN =2;
    public static final int BLUE = 3;
    public static final int GREY_SCALE=4;
    public static final int RGB = 5;
    public static BufferedImage pick() {
    
        BufferedImage imagen = null;
        String direccionImagen = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(filtro);
        int valorFileChooser = fileChooser.showOpenDialog(null);
        
        if(valorFileChooser == JFileChooser.APPROVE_OPTION) {
            
            direccionImagen = fileChooser.getSelectedFile().getAbsolutePath();
        }
        try {
            imagen = ImageIO.read(new File(direccionImagen));
            
        }catch(IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        return imagen;
    }
    public static int[][] bufferToMatriz(BufferedImage imagen, int modo) {
        
        WritableRaster raster;
        int[][] matriz;
        int numBands;
        
        raster = imagen.getRaster();
        numBands = raster.getNumBands();
        matriz      = new int[imagen.getHeight()][imagen.getWidth()];
        
        switch (modo) {
            case RED: {
                for(int i=0; i<imagen.getHeight();i++) {
            
                    for(int j=0; j<imagen.getWidth();j++) {
                
                        if(numBands == 3 || numBands ==4) {
                    
                            matriz[i][j]=   raster.getSample(j, i, 0);
                        }
                        if(numBands == 1) {
                    
                            matriz[i][j]= 255;
                        }
                    }
                }
                return matriz;
            }
            case GREEN: {
                for(int i=0; i<imagen.getHeight();i++) {

                    for(int j=0; j<imagen.getWidth();j++) {

                        if(numBands == 3|| numBands == 4) {

                            matriz[i][j]= raster.getSample(j, i, 1);
                        }
                        if(numBands == 1) {

                            matriz[i][j]= 255;
                        }
                    }
                }
                return matriz;
            }
            case BLUE: {
                for(int i=0; i<imagen.getHeight();i++) {

                    for(int j=0; j<imagen.getWidth();j++) {

                        if(numBands == 3 || numBands == 4) {

                            matriz[i][j] = raster.getSample(j, i, 2);
                        }
                        if(numBands == 1) {

                            matriz[i][j] = 255;
                        }
                    }
                }
                return matriz;
            }
            case GREY_SCALE: {
                    for(int i=0; i<imagen.getHeight();i++) {

                        for(int j=0; j<imagen.getWidth();j++) {

                            if(numBands == 3 || numBands==4) {

    //                    matrizGreyScale[i][j] = (int)((3* raster.getSampleFloat(j, i, 0))/10 
    //                            + (59*raster.getSampleFloat(j, i, 1))/100 
    //                            + (11*raster.getSampleFloat(j, i, 2))/100);
                                matriz[i][j] =(int)( raster.getSampleDouble(j, i, 0)
                                                + raster.getSampleDouble(j, i, 1)
                                                + raster.getSample(j, i, 2))/3;
                            }
                            if(numBands == 1) {

                                matriz[i][j]   = raster.getSample(j, i, 0);
                            }
                        
                        }
                    }
            return matriz;
            }
            case RGB: {
                for(int i=0;i<imagen.getHeight();i++) {

                    for(int j=0;j<imagen.getWidth();j++) {

                        matriz[i][j] = imagen.getRGB(j,i);
                    }
                }
        return matriz;
            }
            default:
                System.out.println("Entradade modo inválida");
                return null; 
        }
    }
    public static BufferedImage matricesToBufferedImage(int[][] matrizRed, int[][] matrizGreen, int[][] matrizBlue) {
        
        int alto = matrizRed.length;
        int ancho  = matrizRed[0].length;
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        
        WritableRaster wr = imagen.getRaster();
        
        for( int i=0; i<alto; i++) {
            for(int j=0; j<ancho; j++) {
                wr.setSample(j, i, 0, matrizRed[i][j]);
                wr.setSample(j, i, 1, matrizGreen[i][j]);
                wr.setSample(j, i, 2, matrizBlue[i][j]);
            }
        }
        imagen.setData(wr);
        return imagen;
    }
    public static BufferedImage matrizGSToImagen (int[][] matriz) {
        int alto = matriz.length;
        int ancho = matriz[0]. length;
        
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = imagen.getRaster();
        
        for (int i=0 ;i<alto ; i++) {

            for(int j=0 ; j<ancho; j++) {

                wr.setSample(j, i, 0, matriz[i][j]);
            }
        }
        imagen.setData(wr);
        return imagen;
    }
    
    public static int[][] limpiarGB(BufferedImage imagen) {
        int[][] matrizAEnviar = null;
        matrizAEnviar = bufferToMatriz(matrizGSToImagen(bufferToMatriz(imagen, RED)), GREY_SCALE);
        return matrizAEnviar;
    }
    public static int umbralizacionPorOtsu(int[] histograma, int size) {
        
        double[] prob= new double[histograma.length];
        for(int i=0; i<histograma.length;i++) {
            prob[i] = (double)histograma[i]/size;
            
        } 
        
        double[] sumAcum = new double[histograma.length];
        double[] medAcum = new double[histograma.length];
        double[] varianza = new double[histograma.length];
        for(int i=0; i<histograma.length;i++) {
            sumAcum[i] =0;
            medAcum[i] =0;
        }
        double medGlobal= 0;
        for(int i=0; i<histograma.length;i++) {
            for(int j=0; j<=i ;j++) {
                sumAcum[i] = sumAcum[i] + prob[j];
                medAcum[i] = medAcum[i] + j*prob[j];
                
            }
            
        }
        
        for(int i=0; i<histograma.length;i++) {
            medGlobal = medGlobal + i*prob[i];
          
        }
        double auxiliar;
        
        
        for(int i=0; i< histograma.length ; i++) {
            auxiliar = Math.pow(medGlobal*sumAcum[i]-medAcum[i], 2);
            if(auxiliar == 0) 
            {varianza[i] = 0;
                continue;
            }
            else {
                varianza[i] = (Math.pow(medGlobal*sumAcum[i]-medAcum[i], 2))/(sumAcum[i]*(1-sumAcum[i])) ;
            }
            
            
        }
        
        int umbral;
        umbral = devolverIndiceMayor(varianza);
        return umbral;
        
    }
    
    private static int devolverIndiceMayor(double[] array) {
        double numeroMayor;
        int posicion;
        numeroMayor = array[0];
        posicion = 0;
        
        for( int i=1; i<array.length ; i++) {
            if(array[i] > numeroMayor) {
                numeroMayor = array[i];
                posicion = i;
            }
        }
        return posicion;
    }
    public static int[][] binarizacionPorUmbral(int[][] matrizGrey, int umbral) {
        
        for (int[] matrizGrey1 : matrizGrey) {
            for (int j = 0; j<matrizGrey[0]. length; j++) {
                if (matrizGrey1[j] <= umbral) {
                    matrizGrey1[j] = 0;
                } else {
                    matrizGrey1[j] = 255;
                }
            }
        }
        return matrizGrey;
    }
    public static int[][] filtroGaussiano(int[][] matriz) {
        int[][] matrizAEnviar = new int[matriz.length][matriz[0].length];
        
        for(int i=0; i<matriz.length ; i++) {
                    for(int j=0; j<matriz[0].length;j++) {
                        matrizAEnviar[i][j] = matriz[i][j];
                    }
                }
//        double[][] gaussiano = {{0.0625, 0.125, 0.0625},{0.125, 0.25, 0.125},{0.0625, 0.125, 0.0625}};
        
        for(int i=1; i<matriz.length-1 ; i++) {
                    for(int j=1; j<matriz[0].length-1;j++) {
//                        matrizAEnviar[i][j] = (int) ((double)matriz[i-1][j-1]*gaussiano[0][0] + (double)matriz[i-1][j]*gaussiano[0][1] + (double)matriz[i-1][j+1]*gaussiano[0][2]+
//                                        (double)matriz[i][j-1]*gaussiano[1][0] + (double)matriz[i][j]*gaussiano[1][1] + (double)matriz[i][j+1]*gaussiano[1][2]+
//                                        (double)matriz[i+1][j-1]*gaussiano[2][0] + (double)matriz[i+1][j]*gaussiano[2][1] + (double)matriz[i+1][j+1]*gaussiano[2][2]);
                       matrizAEnviar[i][j] = (int)(matriz[i-1][j-1] + 2*matriz[i-1][j] + matriz[i-1][j+1] +
                                             2* matriz[i][j-1] + 4*matriz[i][j] + 2*matriz[i][j+1]+
                                             matriz[i+1][j-1] + 2*matriz[i+1][j] + matriz[i+1][j+1])/16;
                    }
                }
        return matrizAEnviar;
    }
    public static int[] crearMatrizHistograma(int [][] matriz) {
        int[] histograma = new int[256];
        
        
        for(int i=0; i<matriz.length;i++) {
            for(int j=0;j<matriz[0].length;j++) {
                histograma[matriz[i][j]]++;
            }
        }
        return histograma;
    }
    public static BufferedImage preProceso(BufferedImage imagen ) {
        BufferedImage bufferAEnviar = null;
        int[][] matrizGrey = bufferToMatriz(imagen, GREY_SCALE);
        matrizGrey = filtroGaussiano(matrizGrey);
        bufferAEnviar = matrizGSToImagen(binarizacionPorUmbral(matrizGrey,umbralizacionPorOtsu(crearMatrizHistograma(matrizGrey),matrizGrey.length*matrizGrey[0].length)));
        return bufferAEnviar;
    }
    public static BufferedImage descripcion(BufferedImage imagenBinarizada, BufferedImage imagenOriginal, VentanaPrincipal ventana) {
        BufferedImage bufferBinarizado = null;
        int[][] matrizBin = bufferToMatriz(imagenBinarizada, GREY_SCALE);
        int[][] matrizOrRed = bufferToMatriz(imagenOriginal, RED);
        int[][] matrizOrGreen = bufferToMatriz(imagenOriginal, GREEN);
        int[][] matrizOrBlue = bufferToMatriz(imagenOriginal, BLUE);
        
        float[][] Hue = new float[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        float[][] Sat = new float[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        float[][] Val = new float[imagenOriginal.getHeight()][imagenOriginal.getWidth()];
        
        float rPrima = 0;
        float gPrima = 0;
        float bPrima = 0;
        float cmax = 0;
        float cmin = 0;
        
        int contador = 0;
        
        for(int i=0; i< Hue.length ; i++) {
            for(int j=0; j<Hue[0].length ; j++) {
                rPrima = (float)matrizOrRed[i][j]/255;
                gPrima = (float)matrizOrGreen[i][j]/255;
                bPrima = (float)matrizOrBlue[i][j]/255;
                cmax = Math.max(rPrima, Math.max(gPrima, bPrima));
                cmin = Math.min(rPrima, Math.min(gPrima, bPrima));
                
                if(cmax-cmin ==0) {
                    Hue[i][j] = 0;
                } else {
                    if(cmax == rPrima) {
                    Hue[i][j] = 60*((gPrima-bPrima)/(cmax-cmin)%6);
                    } else 
                        if(cmax == gPrima) {
                            Hue[i][j] = 60*((bPrima-rPrima)/(cmax-cmin)+2);
                        }else 
                            if(cmax == bPrima) {
                                Hue[i][j] = 60*((rPrima-gPrima)/(cmax-cmin)+4);
                            }
                }
                if(Hue[i][j] <0) Hue[i][j]=Hue[i][j]+360;
                if(cmax==0) {
                    Sat[i][j] =0;
                } else {
                    Sat[i][j] = (cmax-cmin)/cmax *100;
                }
                Val[i][j] = cmax * 100;
//                System.out.println(matrizOrRed[i][j] + " " + matrizOrGreen[i][j] +" " +matrizOrBlue[i][j]);
//                System.out.println(rPrima + " " + gPrima + " " + bPrima + " " +Hue[i][j]+ "\n");
                  //System.out.println(Hue[i][j] + " " + Sat[i][j] + " " + Val[i][j]);
            }
        }
        for(int i=0; i<matrizBin.length ; i++) {
            for(int j=0; j<matrizBin[0].length;j++) {
                if(matrizBin[i][j]== 0) {   
                    if((Hue[i][j] >300 || Hue[i][j]<30) && Sat[i][j]>25 && Val[i][j]>25) {
                        matrizOrRed[i][j] = 255;
                        matrizOrGreen[i][j] = 0;
                        matrizOrBlue[i][j] = 0;
                        
                        contador++;
                    } else {
                        matrizOrRed[i][j] = 0;
                        matrizOrGreen[i][j] = 217;
                        matrizOrBlue[i][j] = 11;
                    }
                    
                }
            }
        }
        bufferBinarizado = matricesToBufferedImage(matrizOrRed, matrizOrGreen, matrizOrBlue);
        ventana.pixelsTotales = devolverCantidadDePixeles(imagenBinarizada);
        ventana.pixelsAFavor = contador;
        return bufferBinarizado;
    }
    public static BufferedImage segmentacion(BufferedImage imagenBinarizada, BufferedImage imagenOriginal) {
        BufferedImage bufferBinarizado = null;
        int[][] matrizBin = bufferToMatriz(imagenBinarizada, GREY_SCALE);
        int[][] matrizOrRed = bufferToMatriz(imagenOriginal, RED);
        int[][] matrizOrGreen = bufferToMatriz(imagenOriginal, GREEN);
        int[][] matrizOrBlue = bufferToMatriz(imagenOriginal, BLUE);
        
        for(int i=0; i<matrizBin.length; i++) {
            for(int j=0; j<matrizBin[0].length;j++) {
                if(matrizBin[i][j] == 255) {
                    matrizOrRed[i][j] = 0;
                    matrizOrGreen[i][j] = 0;
                    matrizOrBlue[i][j] = 0;
                }
            }
        }
        return matricesToBufferedImage(matrizOrRed, matrizOrGreen, matrizOrBlue);
    }
    public static int devolverCantidadDePixeles(BufferedImage imagen) {
        int[][] matrizBin = bufferToMatriz(imagen, GREY_SCALE);
        int contador = 0;
        for(int i=0; i<matrizBin.length ; i++) {
            for(int j=0; j<matrizBin[0].length;j++) {
                if(matrizBin[i][j]== 0) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
