
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MarcoDeDatos m = new MarcoDeDatos();
        boolean bucle = true;
        ArrayList<Datos> dataBase = new ArrayList<Datos>();
        System.out.println("Hola Usuario \npara continuar por favor indique la dirección de la tabla que desea analizar según indica el siguiente ejemplo: (C:\\Users\\Lenovo\\Downloads\\Bogota.csv)");
        String UbicaciónString = sc.next();
        ArrayList<ArrayList<String>> list = m.leerCSV(UbicaciónString);
            for (ArrayList<String> a : list) {
                Datos x = new Datos(a);
                dataBase.add(x);
            }
        while (bucle){
            System.out.println("dijiteel numero de la función que desea utlizar:\n1    imprimir tabla de datos \n2 para crear tabla con lineas añadidas \n3   conseguir los promedios de los cuatro valores numéricos presentes en el CSV \n4 para filtrar los valores según lo requiera el usuario \n5 para hayar maximos o minimos ");
            int función = sc.nextInt();

            if (función == 1) {
                System.out.println("Estcación    |  Nombre del lugar   |  Fecha     | Promedio de precipitaciones  |  Temperatura media   |  Temperatura maxima  |  Temperatura minima\n" +
                        "-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (int i = 0; i < dataBase.size(); i++) {
                    if (dataBase.get(i).getPrcp().equals("")) {
                        System.out.print(dataBase.get(i).getStation() + "  |  " + dataBase.get(i).getName() + " | " + dataBase.get(i).getDate() + " | " + dataBase.get(i).getPrcp() + "                              | ");
                    } else {
                        if (Float.valueOf(dataBase.get(i).getPrcp()) >= 10) {
                            if (Float.valueOf(dataBase.get(i).getPrcp()) >= 100) {
                                System.out.print(dataBase.get(i).getStation() + "  |  " + dataBase.get(i).getName() + " | " + dataBase.get(i).getDate() + " | " + dataBase.get(i).getPrcp() + "                         | ");
                            } else {
                                System.out.print(dataBase.get(i).getStation() + "  |  " + dataBase.get(i).getName() + " | " + dataBase.get(i).getDate() + " | " + dataBase.get(i).getPrcp() + "                          | ");
                            }
                        } else {
                            System.out.print(dataBase.get(i).getStation() + "  |  " + dataBase.get(i).getName() + " | " + dataBase.get(i).getDate() + " | " + dataBase.get(i).getPrcp() + "                           | ");
                        }
                    }
                    if (dataBase.get(i).getTavg().equals("")) {
                        System.out.print(dataBase.get(i).getTavg() + "                    | ");
                    } else {
                        if (Float.valueOf(dataBase.get(i).getTavg()) >= 10) {
                            if (Float.valueOf(dataBase.get(i).getTavg()) < 100) {
                                System.out.print(dataBase.get(i).getTavg() + "                | ");
                            } else {
                                System.out.print(dataBase.get(i).getTavg() + "               | ");
                            }
                        } else {
                            if (Float.valueOf(dataBase.get(i).getTavg()) < 10) {
                                System.out.print(dataBase.get(i).getTavg() + "                 | ");
                            }
                        }
                    }
                    if (dataBase.get(i).getTmax().equals("")) {
                        System.out.print(dataBase.get(i).getTmax() + "                     | ");
                    } else {
                        if (Float.valueOf(dataBase.get(i).getTmax()) > 10) {
                            if (Float.valueOf(dataBase.get(i).getTmax()) > 100) {
                                System.out.print(dataBase.get(i).getTmax() + "                | ");
                            } else {
                                System.out.print(dataBase.get(i).getTmax() + "                 | ");
                            }
                        } else {
                            System.out.print(dataBase.get(i).getTmax() + "                  | ");
                        }
                    }
                    System.out.print(dataBase.get(i).getTmin() + "\n");
                }
            }
             if(función == 2) {
                    try {
                        FileWriter myWriter = new FileWriter ( "C:\\Users\\Lenovo\\Downloads\\Tablamodificada.CSV");
                        myWriter.append( "STATION");
                        myWriter.append( ",");
                        myWriter.append( "\"NAME\"");
                        myWriter.append( ',');
                        myWriter.append( "\"DATE\"");
                        myWriter.append( ",");
                        myWriter.append( "\"PRCP\"");
                        myWriter.append( ",");
                        myWriter.append( "\"TAVG\"");
                        myWriter.append( ",");
                        myWriter.append( "\"TMAX\"");
                        myWriter.append(",");
                        myWriter.append( "\"TMIN\"");
                        myWriter.append( "\n");
                        for (ArrayList<String> a : list) {
                            myWriter.append(a.get(0));
                            myWriter.append( ",");
                            myWriter.append(a.get(1));
                            myWriter.append( ',');
                            myWriter.append(a.get(2));
                            myWriter.append( ",");
                            myWriter.append(a.get(3));
                            myWriter.append( ",");
                            myWriter.append(a.get(4));
                            myWriter.append(",");
                            myWriter.append(a.get(5));
                            myWriter.append(",");
                            myWriter.append(a.get(6));
                            myWriter.append( "\n");
                        }
                        System.out.println("cuantas lineas desea agregar al archivo (el nuevo archivo se guardará con el nombre de Tablamodificada.CSV)");
                        int lines = sc.nextInt();
                        for(int i = 0; i < lines; i++) {
                            System.out.println("dijite Station ");
                            String station = sc.next();
                            myWriter.append(station);
                            myWriter.append( ",");
                            System.out.println("dijite Name ");
                            String name = sc.next();
                            myWriter.append("\"");
                            myWriter.append(name);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            System.out.println("dijite Date ");
                            String date = sc.next();
                            myWriter.append("\"");
                            myWriter.append(date);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            System.out.println("dijite Prcp ");
                            String prcp = sc.next();
                            myWriter.append("\"");
                            myWriter.append(prcp);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            System.out.println("dijite TAVG ");
                            String tavg = sc.next();
                            myWriter.append("\"");
                            myWriter.append(tavg);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            System.out.println("dijite TMAX ");
                            String tmax = sc.next();
                            myWriter.append("\"");
                            myWriter.append(tmax);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            System.out.println("dijite TMIN ");
                            String tmin = sc.next();
                            myWriter.append("\"");
                            myWriter.append(tmin);
                            myWriter.append("\"");
                            myWriter.append( ",");
                            myWriter.append( "\n");
                        }
                        myWriter.flush ();
                        myWriter.close ();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (función == 3) {
                    //media de prcp
                    float contador = 0;
                    float sumana = 0;
                    for (int i = 0; i < dataBase.size(); i++) {
                        if (dataBase.get(i).getPrcp().equals(" ")) {
                            sumana += 1;
                        } else {
                            contador += Float.valueOf(dataBase.get(i).getPrcp());
                        }
                    }
                    float p = contador / (dataBase.size() - sumana);
                    System.out.println("el promedio de prcp es " + p);

                    //media de tavg
                    contador = 0;
                    sumana = 0;
                    for (int i = 0; i < dataBase.size(); i++) {
                        if (dataBase.get(i).getTavg().equals("")) {
                            sumana += 1;
                        } else {
                            contador += Float.valueOf(dataBase.get(i).getTavg());
                        }
                    }
                    p = contador / (dataBase.size() - sumana);
                    System.out.println("el promedio de Tavg es " + p);

                    //la media de tmax
                    contador = 0;
                    sumana = 0;
                    for (int i = 0; i < dataBase.size(); i++) {
                        if (dataBase.get(i).getTmax().equals("")) {
                            sumana += 1;
                        } else {
                            contador += Float.valueOf(dataBase.get(i).getTmax());
                        }
                    }
                    p = contador / (dataBase.size() - sumana);
                    System.out.println("el promedio de Tmax es " + p);

                    //la media de tmin
                    contador = 0;
                    sumana = 0;
                    for (int i = 0; i < dataBase.size(); i++) {
                        if (dataBase.get(i).getTmin().equals("")) {
                            sumana += 1;
                        } else {
                            contador += Float.valueOf(dataBase.get(i).getTmin());
                        }
                    }
                    p = contador / (dataBase.size() - sumana);
                    System.out.println("el promedio de Tmin es " + p);
                }

                if(función == 4) {
                    int i = 0;
                    System.out.println("hola usario digite 1 si quiere las temperaturas maximas, digite 2 si quiere las temperaturas minimas, digite 3 si quiere el promedio de precipitaciones, digite 4 si quiere la temperatura media ");
                    int digito = sc.nextInt();
                    if (digito == 1) {
                        System.out.println("digite una temperatura ");
                        double tempUs = sc.nextDouble();
                        System.out.println("digite 1 si quiere ver las temperaturas maximas mayores a la temperatura escrita o 2 si quiere ver las menores a la temperatura escrita ");
                        int digito2 = sc.nextInt();
                        if (digito2 == 1) {
                            while (i < dataBase.size()) {
                                if (dataBase.get(i).getTmax().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTmax()) > tempUs) {
                                        System.out.println("Station:" + dataBase.get(i).getStation() + " | Name:" + dataBase.get(i).getName() + " | Date:" + dataBase.get(i).getDate() + " | PRCP:" + dataBase.get(i).getPrcp() + " | TAVG:" + dataBase.get(i).getTavg() + " | TMAX:" + dataBase.get(i).getTmax() + " | TMIN:" + dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else if (digito2 == 2) {
                            while (i < dataBase.size()) {
                                if (dataBase.get(i).getTmax().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTmax()) < tempUs) {
                                        System.out.println( "PRCP:" + dataBase.get(i).getPrcp() + " | TAVG:" + dataBase.get(i).getTavg() + " | TMAX:" + dataBase.get(i).getTmax() + " | TMIN:" + dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Porfavor digite un numero que sea 1 o 2 ");
                        }
                    } else if (digito == 2) {
                        System.out.println("digite una temperatura ");
                        double tempUs = sc.nextDouble();
                        System.out.println("digite 1 si quiere ver las temperaturas minimas mayores a la temperatura escrita o 2 si quiere ver las menores a la temperatura escrita ");
                        int digito2 = sc.nextInt();
                        if (digito2 == 1) {
                            while (i < dataBase.size()) {
                                if (dataBase.get(i).getTmin().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTmin()) > tempUs) {
                                        System.out.println(dataBase.get(i).getTmin());
                                        i++;

                                    }
                                }
                            }
                        } else if (digito2 == 2) {
                            while (i < dataBase.size()) {
                                if (dataBase.get(i).getTmin().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTmin()) < tempUs) {
                                        System.out.println(dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Porfavor digite un numero que sea 1 o 2 ");
                        }
                    } else if (digito == 3) {
                        System.out.println("digite una precipitación ");
                        double tempUs = sc.nextDouble();
                        System.out.println("digite 1 si quiere ver las precipitaciones mayores al valor que escrito o 2 si quiere ver las menores ");
                        int digito2 = sc.nextInt();
                        if (digito2 == 1) {
                            while (i < dataBase.size()) {
                                if (dataBase.get(i).getPrcp().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getPrcp()) > tempUs) {
                                        System.out.println(dataBase.get(i).getPrcp());
                                        i++;
                                    }
                                }
                            }
                        } else if (digito2 == 2) {
                            while(i < dataBase.size()) {
                                if (dataBase.get(i).getPrcp().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getPrcp()) < tempUs) {
                                        System.out.println("Station:" + dataBase.get(i).getStation() + " | Name:" + dataBase.get(i).getName() + " | Date:" + dataBase.get(i).getDate() + " | PRCP:" + dataBase.get(i).getPrcp() + " | TAVG:" + dataBase.get(i).getTavg() + " | TMAX:" + dataBase.get(i).getTmax() + " | TMIN:" + dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Porfavor digite un numero que sea 1 o 2 ");
                        }
                    } else if (digito == 4) {
                        System.out.println("digite una temperatura ");
                        double tempUs = sc.nextDouble();
                        System.out.println("digite 1 si quiere ver las temperaturas medias mayores al valor que escrito o 2 si quiere ver las menores ");
                        int digito2 = sc.nextInt();
                        if (digito2 == 1) {
                            while(i < dataBase.size()){
                                if (dataBase.get(i).getTavg().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTavg()) > tempUs) {
                                        System.out.println("Station:" + dataBase.get(i).getStation() + " | Name:" + dataBase.get(i).getName() + " | Date:" + dataBase.get(i).getDate() + " | PRCP:" + dataBase.get(i).getPrcp() + " | TAVG:" + dataBase.get(i).getTavg() + " | TMAX:" + dataBase.get(i).getTmax() + " | TMIN:" + dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else if (digito2 == 2) {
                            while(i < dataBase.size()){
                                if (dataBase.get(i).getTavg().equals("")) {
                                    i++;
                                } else {
                                    if (Float.valueOf(dataBase.get(i).getTavg()) < tempUs) {
                                        System.out.println("Station:" + dataBase.get(i).getStation() + " | Name:" + dataBase.get(i).getName() + " | Date:" + dataBase.get(i).getDate() + " | PRCP:" + dataBase.get(i).getPrcp() + " | TAVG:" + dataBase.get(i).getTavg() + " | TMAX:" + dataBase.get(i).getTmax() + " | TMIN:" + dataBase.get(i).getTmin());
                                        i++;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Porfavor digite un numero que sea 1 o 2 ");
                        }
                    }
                }

                if(función == 5){
                    System.out.println("Hola usario digite 1 si quiere la temperatura maxima mas alta, digite 2 si quiere la temperatura maxima mas baja, digite 3 si quiere la temperatura minima mas alta, digite 4 si quiere la temperatura minima mas baja, digite 5 si quiere el promedio de precipitaciones mas alto, digite 6 si quiere el promedio de precipitaciones mas bajo, digite 7 si quiere la temperatura media mas alta, digite 8 si quiere la temperatura media mas baja");
                    float usuario = sc.nextInt();
                    float maximo = 0;
                    float minimo = 0;
                    float maximo2 = 0;
                    float minimo2 = 0;
                    float maximo3 = 0;
                    float minimo3 = 0;
                    float maximo4 = 0;
                    float minimo4 = 0;
                    for (int i = 0; i < dataBase.size(); i++){
                        if(dataBase.get(i).getTmax().equals("")){
                            break;
                        }
                        else{
                            if (usuario == 1){
                                if (Float.valueOf(dataBase.get(i).getTmax()) > maximo){
                                    maximo = Float.valueOf(dataBase.get(i).getTmax());
                                }
                            }
                            else if(usuario == 2){
                                if (Float.valueOf(dataBase.get(i).getTmax()) < minimo){
                                    minimo = Float.valueOf(dataBase.get(i).getTmax());
                                    
                                }
                            }
                            else if(usuario == 3){
                                if (Float.valueOf(dataBase.get(i).getTmin()) > maximo2){
                                    maximo2 = Float.valueOf(dataBase.get(i).getTmin());
                                    
                                }
                            }
                            else if(usuario == 4){
                                if (Float.valueOf(dataBase.get(i).getTmin()) < minimo2){
                                    minimo2 = Float.valueOf(dataBase.get(i).getTmin());
                                    
                                 }
                            }
                             else if(usuario == 5){
                                 if (Float.valueOf(dataBase.get(i).getPrcp()) > maximo3){
                                    maximo3 = Float.valueOf(dataBase.get(i).getPrcp());
                                    
                                  }
                            }
                             else if(usuario == 6){
                                if (Float.valueOf(dataBase.get(i).getPrcp()) < minimo3){
                                  minimo3 = Float.valueOf(dataBase.get(i).getPrcp());
                                  
                                  }
                             }
                             else if(usuario == 7){
                                  if (Float.valueOf(dataBase.get(i).getTavg()) > maximo4){
                                     minimo4 = Float.valueOf(dataBase.get(i).getTavg());
                                    }
                            }
                             else if(usuario == 8){
                                    if (Float.valueOf(dataBase.get(i).getTavg()) < minimo4){
                                         minimo4 = Float.valueOf(dataBase.get(i).getTavg());
                                        
                                    }
                            }
                            else {
                                break;
                            }
                    }
                }
                if(usuario == 1){
                    System.out.println(maximo);
                }
                else if (usuario == 2){
                    System.out.println(minimo);
                }
                else if (usuario == 3){
                    System.out.println(maximo2);
                }
                else if (usuario == 4){
                    System.out.println(minimo2);
                }
                else if (usuario == 5){
                    System.out.println(maximo3);
                }
                else if (usuario == 6){
                    System.out.println(minimo3);
                }
                else if (usuario == 7){
                    System.out.println(maximo4);
                }
                else if (usuario == 8){
                    System.out.println(minimo4);
                }
            }
        }
    }
}



