/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Asier Loayza - 
 */
public class Podometro {
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;
    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca= queMarca;
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if (sexo == MUJER)  {
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }
        
        else    {
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
        }
    }

     /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
                            int horaFin) {
        String queDia = "";
        
        tiempo = tiempo + (horaFin - horaInicio);
        double laborables = 0, dia6 = 0, dia7 = 0;
        
        if (dia >= 1 && dia <= 7) {
            
            switch (dia)    {
                case 1: queDia = "Lunes";
                    break;
                case 2: queDia = "Martes";
                    break;
                case 3: queDia = "Miercoles";
                    break;
                case 4: queDia = "Jueves";
                    break;
                case 5: queDia = "Viernes";
                    break;
                case 6: queDia = "Sabado";
                    break;
                default: queDia = "Domingo";
                    break;
            
            }
            if (dia >= 1 && dia <= 5)  {    
                totalPasosLaborables += pasos;
                if (sexo == MUJER) {
                    laborables = pasos * ZANCADA_MUJER;    
                    
                }
                
                else if (sexo == HOMBRE)   {
                    laborables = pasos * ZANCADA_HOMBRE; 
                }
            }
            if (dia >= 6 && dia <= 7)   {    
                if (dia == 6)   {
                    totalPasosSabado += pasos;
                    if (sexo == MUJER) {
                        dia6 = pasos * ZANCADA_MUJER;  
                    }
                    
                    else if (sexo == HOMBRE){
                        dia6 = pasos * ZANCADA_HOMBRE; 
                    }
                }
                if (dia == 7)   {
                    totalPasosDomingo += pasos;
                    if (sexo == MUJER) {
                        dia6 = pasos * ZANCADA_MUJER;  
                    }
                    
                    else if (sexo == HOMBRE){
                        dia6 = pasos * ZANCADA_HOMBRE; 
                    }
                }   
                totalDistanciaFinSemana += (dia6 + dia7);
            }    
            totalDistanciaSemana = totalDistanciaSemana + (laborables + dia6 + dia7);
        }
    
        if (horaInicio >= 2100 && horaInicio <= 2400)   {
            caminatasNoche++;
        }
        

    }
    
     /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        
        System.out.println("Configuracion del podometro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura / 100 + " mtos");
        System.out.println("Sexo: " + sexo);
        System.out.println("Longitud zancada: " + longitudZancada / 100 + " mtos");    

    }
    
    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        int hora = tiempo / 100;
        int varMinutos = hora * 100;
        int minutos = tiempo - varMinutos;
        System.out.println("Estadisticas");
        System.out.println("***************************");
        System.out.println("Distancia recorrida toda la semana: " + totalDistanciaSemana + " Km");
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana + " Km");
        System.out.println();
        System.out.println("N� pasos d�as laborables: " + totalPasosLaborables);    
        System.out.println("N� pasos SABADO: " + totalPasosSabado);
        System.out.println("N� pasos DOMINGO: " + totalPasosDomingo);
        System.out.println();
        System.out.println("N� caminatas realizadas a partir de las 21h : " + caminatasNoche);
        System.out.println();
        System.out.println("Tiempo total caminado en la semana: "+ hora + "h. y " + minutos + "m.");
        System.out.println("D�a/s con m�s pasos caminados: ");    

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        if ((totalPasosLaborables > totalPasosSabado) && (totalPasosLaborables > totalPasosDomingo))    {
            if (totalPasosLaborables >= totalPasosSabado)   {
                return "LABORABLES SABADO";
            }
            else if (totalPasosLaborables >= totalPasosDomingo) {
                return "LABORABLES DOMINGO";
            }
            return "LABORABLES";
        }
        if ((totalPasosSabado > totalPasosLaborables) && (totalPasosSabado > totalPasosDomingo))    {
            if (totalPasosLaborables >= totalPasosDomingo) {
                return "SABADO DOMINGO";
            }
            return "SABADO";
        }        
        if ((totalPasosSabado > totalPasosLaborables) && (totalPasosSabado > totalPasosDomingo))    {
            return "DOMINGO";
        }
        
        return marca;
    }            
        
    
    
    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;    
    }

}
