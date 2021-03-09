package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Rombo extends Figura{
    
    public Rombo(){
        super();
         
    }

    
    public Rombo(int diagonalMayor, int diagonalMenor) {
        
        if ((diagonalMayor <= 0) || (diagonalMenor <= 0)) {
            throw new ArithmeticException("Error,"
                    + " ha introducido una diagonal igual"
                    + " o menor a cero");
        }
        
        this.altura = diagonalMayor;
        this.base = diagonalMenor;
    }

    public float getDiagonalMayor() {
        return altura;
    }

    public void setDiagonalMayor(float diagonalMayor) {
        this.altura = diagonalMayor;
    }

    public float getDiagonalMenor() {
        return base;
    }

    public void setDiagonalMenor(float diagonalMenor) {
        this.base = diagonalMenor;
    }
    
    @Override
    public float area() {
        return (float)(altura*base)/2;
    }
    
    
}
