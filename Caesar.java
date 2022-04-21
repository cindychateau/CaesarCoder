public class Caesar {
    /*
    input = "HOLAZ"
    shift = 3

    resultado = ""
    
    letra = "H";
    indice = 7
    indice+shift <= 25 -> 10
    resultado += letras[7+3]; -> letras[10];
    resultado = K

    letra = O
    indice = 14
    resultado += letras[14+3] -> letras[17]
    resultado = KR

    letra = L
    indice = 11
    resultado += letras[11+3]-> letras[14]
    resultado = KRO

    letra = A
    indice = 0
    resultado += letras[0+3]-> letras[3]
    resultado = KROD

    letra = Z
    indice = 25
    resultado += letras[25+3-26]-> letras[2]
    resultado = KRODC


    ----------------
    input = IR
    shift = -3
    resultado = ""

    letra = I
    indice = 8    
    8 + (-3) ->5
    resultado += letras[8+(-3)]->letras[5]
    resultado = F

    letra = R
    indice = 17
    17 + (-3) = 14
    resultado += letras[17+(-3)]->letras[14]
    resultado = FO
     */

    public static String codificar( String input, int shift){
        char letras[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        String resultado = "";
        input = input.toUpperCase();
        //SI podemos codificar
        if(shift >= -25 && shift <= 25){
            //Recorremos todas las letras
            for(int i=0; i<input.length(); i++){
                
                char letra = input.charAt(i); //Obtener la letra en posición
                if( letra == ' ' ){
                    resultado += letra;
                } else {
                    //H->72  A->65 -> INDICE de nuestro arreglo
                    int indice = letra - 'A'; //Esto nos va a dar el índice
                    System.out.println("Letra:"+(int)letra+ "- "+letra+" indice:"+indice);

                    //Shift positivo
                    if(shift >= 0){
                        
                        if(indice+shift <= 25){
                            resultado += letras[indice+shift];
                        } else {
                            resultado += letras[indice + shift - 26];
                        }


                    } else { //Shift negativo
                        
                        if(indice+shift >= 0){
                            resultado += letras[indice+shift];
                        } else {
                            resultado += letras[indice+shift + 26];
                        }

                    }

                }

            }


        } else {
            return "No se puede codificar, shift fuera del rango";
        }

        return resultado;


    }    

    public static void main( String args[] ){
        String input = "IR";
        int shift = -3;
        System.out.println( codificar(input, shift) );
    }
}