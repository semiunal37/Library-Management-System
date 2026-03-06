import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Items{
    private List<List<String>> list_of_items= new ArrayList<>();

    public List<List<String>> getListItems(){
        return list_of_items;
    }

    public String getName(String id_item) {
         /*item id'sini girdiğinde sana item'in adını String olarak döndürür*/
        for (int index = 0; index < list_of_items.size(); index++) {

            if (id_item.equals(list_of_items.get(index).get(1))) {

                return list_of_items.get(index).get(2);
            }
        }
        return null;
    }

    public String getLevel(String id_item){
        //Bu kod verdiğin id'ye karşılık gelen itemin levelini veriyor
        for (int index = 0; index < list_of_items.size(); index++) {
            if (list_of_items.get(index).get(0).equals("D")) {
                if (id_item.equals(list_of_items.get(index).get(1))) {
                    return list_of_items.get(index).get(6);
                }
            }
            else{
                if (id_item.equals(list_of_items.get(index).get(1))) {
                    return list_of_items.get(index).get(5);
                }
            }
        }
        return null;
    }
    public void setListItems(List<String> liste){
        list_of_items.add(liste);
    }

}
class Books extends Items{
    private List<List<String>> list_of_books= new ArrayList<>();
    public List<List<String>> getListBooks(){
        return list_of_books;
    }
    public void setListBooks(List<String> liste){
        list_of_books.add(liste);
    }
    public void getInfoForBooks(List<List<Object>> borrowed_items,List<String> total_borrowed_items,Users users){
        for (List<String> book:list_of_books){
            System.out.println();
            System.out.println("------ Item Information for "+book.get(1)+" ------");
            if (total_borrowed_items.contains(book.get(1))){
                for (List<Object> user_info:borrowed_items){
                    for (int index=2;index<user_info.size();index++){
                        List<String> item_info =(List<String>) user_info.get(index);
                        if (item_info.get(0).equals(book.get(1))){
                            String user_id=(String) user_info.get(0);
                            System.out.println("ID: "+item_info.get(0)+" Name: "+book.get(2)+" Status: Borrowed Borrowed Date: "+item_info.get(1)+" Borrowed by: "+users.getName(user_id));
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("ID: "+book.get(1)+" Name: "+book.get(2)+ " Status: Available");
            }
            System.out.println("Author: "+book.get(3)+" Genre: "+book.get(4));
        }
    }
}
class Magazine extends Items{
    private List<List<String>> list_of_magazine= new ArrayList<>();

    public List<List<String>> getListMagazine(){
        return list_of_magazine;
    }
    public void setListMagazine(List<String> liste){
        list_of_magazine.add(liste);
    }
    public void getInfoForMagazine(List<List<Object>> borrowed_items,List<String> total_borrowed_items,Users users){
        for (List<String> magazine:list_of_magazine){
            System.out.println();
            System.out.println("------ Item Information for "+magazine.get(1)+" ------");
            if (total_borrowed_items.contains(magazine.get(1))){
                for (List<Object> user_info:borrowed_items){
                    for (int index=2;index<user_info.size();index++){
                        List<String> item_info =(List<String>) user_info.get(index);
                        if (item_info.get(0).equals(magazine.get(1))){
                            String user_id=(String) user_info.get(0);
                            System.out.println("ID: "+item_info.get(0)+" Name: "+magazine.get(2)+" Status: Borrowed Borrowed Date: "+item_info.get(1)+" Borrowed by: "+users.getName(user_id));
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("ID: "+magazine.get(1)+" Name: "+magazine.get(2)+ " Status: Available");
            }
            System.out.println("Publisher: "+magazine.get(3)+" Category: "+magazine.get(4));
        }
    }
}
class DVD extends Items{
    private List<List<String>> list_of_dvd= new ArrayList<>();

    public List<List<String>> getListDVD(){
        return list_of_dvd;
    }
    public void setListDVD(List<String> liste){
        list_of_dvd.add(liste);
    }

    public void getInfoForDVD(List<List<Object>> borrowed_items,List<String> total_borrowed_items,Users users){
        for (List<String> dvd:list_of_dvd){
            System.out.println();
            System.out.println("------ Item Information for "+dvd.get(1)+" ------");
            if (total_borrowed_items.contains(dvd.get(1))){
                for (List<Object> user_info:borrowed_items){
                    for (int index=2;index<user_info.size();index++){
                        List<String> item_info =(List<String>) user_info.get(index);
                        if (item_info.get(0).equals(dvd.get(1))){
                            String user_id=(String) user_info.get(0);
                            System.out.println("ID: "+item_info.get(0)+" Name: "+dvd.get(2)+" Status: Borrowed Borrowed Date: "+item_info.get(1)+" Borrowed by: "+users.getName(user_id));
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("ID: "+dvd.get(1)+" Name: "+dvd.get(2)+ " Status: Available");
            }
            System.out.println("Director: "+dvd.get(3)+" Category: "+dvd.get(4)+" Runtime: "+dvd.get(5));
        }
    }

}
class Users{
    private List<List<String>> list_of_total_users=new ArrayList<>();

    public List<List<String>> getListUsers(){
        return list_of_total_users;
    }
    public String getName(String id_user) {
        for (int index = 0; index < list_of_total_users.size(); index++) {

            if (id_user.equals(list_of_total_users.get(index).get(2))) {

                return list_of_total_users.get(index).get(1);
            }
        }
        return null;
    }

    public void setListUsers(List<String> liste_kullanici){
        list_of_total_users.add(liste_kullanici);
    }


    public String getUserType(String id_user){
        //We can take user type
        for (int index = 0; index < list_of_total_users.size(); index++) {

            if (id_user.equals(list_of_total_users.get(index).get(2))) {
                return list_of_total_users.get(index).get(0);
            }
        }
        return null;
    }
}
class Student extends Users{
    int max_items=5;
    int overdue_days=30;
    ArrayList<String> banned_items= new ArrayList<>(Arrays.asList("reference"));
    private List<List<String>> list_of_total_students=new ArrayList<>();
    public List<List<String>> getListStudent(){
        return list_of_total_students;
    }
    public void setListStudent(List<String> liste_kullanici) {
        list_of_total_students.add(liste_kullanici);
    }
    public void getInfoForStudents(List<List<Object>> borrowed_items){
        for (List<String> student:list_of_total_students){
            System.out.println();
            System.out.println("------ User Information for "+student.get(2)+" ------");
            System.out.println("Name: "+student.get(1)+" Phone: "+student.get(3));
            System.out.println("Faculty: "+ student.get(5)+" Department: "+ student.get(4)+" Grade: "+ student.get(6)+"th");
            for (List<Object> info_user:borrowed_items){
                int penalty = (Integer) info_user.get(1);
                if (info_user.get(0).equals(student.get(2)) && penalty!=0){
                    System.out.println("Penalty: "+penalty+"$");
                }
            }

        }
    }
}

class Academic extends Users{
    int max_items=3;
    int overdue_days=15;
    ArrayList<String> banned_items= new ArrayList<>();
    private List<List<String>> list_of_total_academics= new ArrayList<>();
    public List<List<String>> getListAcademics(){
        return list_of_total_academics;
    }
    public void setListAcademics(List<String> liste_kullanici) {
        list_of_total_academics.add(liste_kullanici);
    }
    public void getInfoForAcademics(List<List<Object>> borrowed_items){
        for (List<String> academic:list_of_total_academics){
            System.out.println();
            System.out.println("------ User Information for "+academic.get(2)+" ------");
            System.out.println("Name: "+academic.get(6)+" "+academic.get(1)+" Phone: "+academic.get(3));
            System.out.println("Faculty: "+ academic.get(5)+" Department: "+ academic.get(4));
            for (List<Object> info_user:borrowed_items){
                int penalty = (Integer) info_user.get(1);
                if (info_user.get(0).equals(academic.get(2)) && penalty!=0){
                    System.out.println("Penalty: "+penalty+"$");
                }
            }
        }
    }
}
class Guest extends Users{
    int max_items=1;
    int overdue_days=7;
    ArrayList<String> banned_items=new ArrayList<>(Arrays.asList("rare","limited"));
    private List<List<String>> list_of_total_guests= new ArrayList<>();
    public List<List<String>> getListGuests(){
        return list_of_total_guests;
    }
    public void setListGuests(List<String> liste_kullanici) {
        list_of_total_guests.add(liste_kullanici);
    }
    public void getInfoForGuest(List<List<Object>> borrowed_items){
        for (List<String> guest:list_of_total_guests){
            System.out.println();
            System.out.println("------ User Information for "+guest.get(2)+" ------");
            System.out.println("Name: "+guest.get(1)+" Phone: "+guest.get(3));
            System.out.println("Occupation: "+guest.get(4));
            for (List<Object> info_user:borrowed_items){
                int penalty = (Integer) info_user.get(1);
                if (info_user.get(0).equals(guest.get(2)) && penalty!=0){
                    System.out.println("Penalty: "+penalty+"$");
                }
            }
        }
    }
}


class Borrow{
    private List<List<Object>> borrowed_items = new ArrayList<>();
    private Items items;
    private Users users;
    Date date=new Date();
    private Student student;
    private Academic academic;
    private  Guest guest;
    private Books books;
    private Magazine magazine;
    private DVD dvd;
    ArrayList<String> total_borrowed_items = new ArrayList<>();

    public List<List<Object>> getBorrowedItems(){
        return borrowed_items;
    }
    /*borrowed_items ifadesi koddaki kilit ifadedir hemen hemen bütün işlemler bu ifade üzerinden yapılır bunun
     yapısı ise [[user_id,penalty,[borrowed_items_id1,borrowed_date1],[borrowed_items_id2,borrowed_date2]]] şeklinde bir yapısı var
     bu yapıda her kullanıcı için listenin içine bir liste daha ekleniyor*/
    public void returnItems(String id_user,String id_item,Users users,Items items){
        List<String> silinecek=new ArrayList<>();
        for (int index=0; index<borrowed_items.size();index++){
            if (id_user.equals(borrowed_items.get(index).get(0)))
                for (int items_index=2;items_index<borrowed_items.get(index).size();items_index++){
                    List<String> item= (List<String>) borrowed_items.get(index).get(items_index);
                    if (id_item.equals(item.get(0))){
                        int sabit_index=index;
                        silinecek=new ArrayList<>(item);
                        break;
                    }
                }
            if (silinecek!=null){
                borrowed_items.get(index).remove(silinecek);
                total_borrowed_items.remove(id_item);
            }

        }

        System.out.println(users.getName(id_user)+ " successfully returned "+ items.getName(id_item));
    }
    public void payPenalty(String id_user,Users users){
        /*borrowed_items'in içinden kimin penalty ödediğini buluyoruz daha sonrasında ise penalty'ı 0'a
        eşitleyerek has paid penalty diyoruz*/
        for (int index=0; index<borrowed_items.size();index++) {
            if (id_user.equals(borrowed_items.get(index).get(0))){
                borrowed_items.get(index).set(1,0);
                System.out.println(users.getName(id_user)+" has paid penalty");
            }
        }
    }

    public void displayUsers(Student student,Academic academic,Guest guest){
        student.getInfoForStudents(borrowed_items);
        academic.getInfoForAcademics(borrowed_items);
        guest.getInfoForGuest(borrowed_items);
    }
    public void displayItems(Books books, Magazine magazine, DVD dvd,Users users){
        books.getInfoForBooks(borrowed_items,total_borrowed_items,users);
        magazine.getInfoForMagazine(borrowed_items,total_borrowed_items,users);
        dvd.getInfoForDVD(borrowed_items,total_borrowed_items,users);
    }

    public void checkReferenceNow(Users users){
        /*Bu fonksiyonu her displayUsers ya da displayItems komutları çalıştığında çalıştırıyorum borrowed_items'deki bütün itemleri
        günümüzü referans alarak kontrol ediyor eğer günü geçtiyse iade edip sahibine ceza yazıyor*/
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String today_date = today.format(formatter);

        for (List<Object> user_info:borrowed_items){
            ArrayList<List<Object>> silinecekler =new ArrayList<>();
            String type_user=users.getUserType(user_info.get(0).toString());
            int penalty = Integer.parseInt(user_info.get(1).toString());
            for (int index = 2; index < user_info.size(); index++) {

                List<Object> innerList = (List<Object>) user_info.get(index);
                String date1 = (String) innerList.get(1);
                int gunFarki = date.differenceDate(date1,today_date);
                if (type_user.equals("S")){
                    if (gunFarki>=30){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                else if (type_user.equals("A")){
                    if (gunFarki>=15){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                else if (type_user.equals("G")){
                    if (gunFarki>=7){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                user_info.set(1,penalty);
            }
            for (List<Object> sil:silinecekler){
                user_info.remove(sil);
            }
        }


    }
    public void borrowItem(String id_user,String id_item,String date2 ,Users users,Items items){
        Boolean check_there_is_id = false;
        String type_of_user = users.getUserType(id_user);
        int max_item=0;
        int overdue=0;
        ArrayList<String> banned_items=new ArrayList<>();

        if (type_of_user.equals("S")){
            max_item=5;
            overdue=30;
            banned_items.add("reference");      //Eğer banned_items'lerde bir sıkıntı çıkarsa bunların türünü ArrayListlerle değiştirerek dene
        }
        else if (type_of_user.equals("A")){
            max_item= 3;
            overdue=15;
        }
        else if (type_of_user.equals("G")){
            max_item= 1;
            banned_items.add("rare");
            banned_items.add("limited");
        }

        for(int e=0;e<borrowed_items.size();e++){
            int penalty = Integer.parseInt(borrowed_items.get(e).get(1).toString());
            List<Object> user_info = borrowed_items.get(e); //kodun daha okunaklı olması için borrowed_items.get(a) ifadelerini user_info ile değiştirebilirsin
            String type_user=users.getUserType(borrowed_items.get(e).get(0).toString());
            ArrayList<List<Object>> silinecekler =new ArrayList<>();
            for (int index = 2; index < borrowed_items.get(e).size(); index++) {

                List<Object> innerList = (List<Object>) borrowed_items.get(e).get(index);
                String date1 = (String) innerList.get(1);
                int gunFarki = date.differenceDate(date1,date2);
                if (type_user.equals("S")){
                    if (gunFarki>=30){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                else if (type_user.equals("A")){
                    if (gunFarki>=15){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                else if (type_user.equals("G")){
                    if (gunFarki>=7){
                        silinecekler.add(innerList);
                        total_borrowed_items.remove(innerList.get(0));
                        penalty+=2;
                    }
                }
                borrowed_items.get(e).set(1,penalty);
            }
            for (List<Object> sil:silinecekler){
                borrowed_items.get(e).remove(sil);
            }
        }
        for (int a=0;a<borrowed_items.size();a++) {

            int penalty = Integer.parseInt(borrowed_items.get(a).get(1).toString());

            if (id_user.equals(borrowed_items.get(a).get(0))) {
                check_there_is_id = true;
                /*Öncelikle penalty 6'dan büyük mü kontrol ediyor*/
                if (penalty >= 6) {
                    System.out.println(users.getName(id_user) + " cannot borrow " + items.getName(id_item) + ", you must first pay the penalty amount! 6$");
                    return;
                }

                if (total_borrowed_items.contains(id_item)) {
                    /*2. olarak almaya çalıştığın item şuan kütüphanede mi yoksa başkası tarafından ödünç alınmış mı onu kontrol ediyor*/
                    System.out.println(users.getName(id_user) + " cannot borrow " + items.getName(id_item) + ", it is not available!");
                    return;
                }
                if (borrowed_items.get(a).size() - 2 == max_item) {
                    /*3. olarak ödünç almaya çalışan kişi max item limitine ulaşmış mı o kontrol ediliyor*/
                    System.out.println(users.getName(id_user) + " cannot borrow " + items.getName(id_item) + ", since the borrow limit has been reached!");
                    return;
                }
                String level_of_item = items.getLevel(id_item);
                for (String banned : banned_items) {
                    if (banned.equals(level_of_item)) {
                        /*4. olarak almaya çalıştığı item'in level'i uygun mu onu kontrol ediyor*/
                        System.out.println(users.getName(id_user) + " cannot borrow " +level_of_item+" item!");
                        return;
                    }
                }
                List<String> info_item= new ArrayList<>();
                info_item.add(id_item);
                info_item.add(date2);
                List<Object> kisi=borrowed_items.get(a);
                kisi.set(1,penalty);
                kisi.add(info_item);
                total_borrowed_items.add(id_item);
                System.out.println(users.getName(id_user) + " successfully borrowed! " + items.getName(id_item));
                return;
            }
        }

        String level_of_item = items.getLevel(id_item);

        for (String banned : banned_items) {

            if (banned.equals(level_of_item)) {
                System.out.println(users.getName(id_user) + " cannot borrow " +level_of_item+" item!");
                return;
            }
        }
        if (total_borrowed_items.contains(id_item)) {
            System.out.println(users.getName(id_user) + " cannot borrow " + items.getName(id_item) + ", it is not available!");
            return;
        }

        if (check_there_is_id==false){
            /*Bu if bloğu işlem yapan user'ın borrowed_items'de olup olmadığını kontrol ediyor eğer yoksa
            yeni bir person listesi oluşturup borrowed_items'e ekliyor*/
            List<Object> person = new ArrayList<>();
            person.add(id_user);
            person.add(0);
            List<String> item_info=new ArrayList<>();
            item_info.add(id_item);
            item_info.add(date2);
            person.add(item_info);
            borrowed_items.add(person);
            total_borrowed_items.add(id_item);
            System.out.println(users.getName(id_user)+" successfully borrowed! "+items.getName(id_item));
            }
    }
    
}

public class Main {
    static  List<List<String>> list_of_total_items=new ArrayList<>();
    static  List<List<String>> list_of_total_users=new ArrayList<>();

    public static void main(String[] args) {
        try {
            String inputFile = args[2];
            String outputFile = args[3];
            String itemsFile=args[0];
            String usersFile=args[1];
            PrintStream fileOut = new PrintStream(new File(outputFile));
            System.setOut(fileOut); // Konsol çıktısını dosyaya yönlendir
            ReadFileText reader_items = new ReadFileText();
            ReadFileText reader_users = new ReadFileText();
            ReadFileText reader_commands = new ReadFileText();
            ArrayList<String> list_items = reader_items.readFile(itemsFile); // Doğru çağırma şekli
            ArrayList<String> commands = reader_commands.readFile(inputFile);
            Items items = new Items();
            Books books = new Books();
            Magazine magazines = new Magazine();
            DVD dvd = new DVD();

            for (String line : list_items) {
                List<String> item = Arrays.asList(line.split(","));
                list_of_total_items.add(item);
                items.setListItems(item);
                String type = item.get(0);
                if (type.equals("B")) {
                    books.setListBooks(item);
                } else if (type.equals("M")) {
                    magazines.setListMagazine(item);
                } else if (type.equals("D")) {
                    dvd.setListDVD(item);
                }
            }

            ArrayList<String> list_users = reader_users.readFile(usersFile);

            Users users = new Users();
            Student student = new Student();
            Academic academic = new Academic();
            Guest guest = new Guest();

            for (String userss : list_users) {
                List<String> user = Arrays.asList(userss.split(","));
                users.setListUsers(user);
                String type_of_user = user.get(0);
                users.setListUsers(user);
                if (type_of_user.equals("S")) {
                    student.setListStudent(user);
                } else if (type_of_user.equals("A")) {
                    academic.setListAcademics(user);
                } else if (type_of_user.equals("G")) {
                    guest.setListGuests(user);
                }
            }
            Borrow borrow = new Borrow();


            for (String line : commands) {
                List<String> command_line = Arrays.asList(line.split(","));
                if (command_line.get(0).equals("borrow")) {
                    String id_user = command_line.get(1);
                    String id_item = command_line.get(2);
                    String date = command_line.get(3);
                    borrow.borrowItem(id_user, id_item, date, users, items);
                } else if (command_line.get(0).equals("return")) {
                    String id_user = command_line.get(1);
                    String id_item = command_line.get(2);
                    borrow.returnItems(id_user, id_item, users, items);
                } else if (command_line.get(0).equals("pay")) {
                    String id_user = command_line.get(1);
                    borrow.payPenalty(id_user, users);
                } else if (command_line.get(0).equals("displayUsers")) {
                    borrow.checkReferenceNow(users);
                    System.out.println();
                    borrow.displayUsers(student, academic, guest);
                } else if (command_line.get(0).equals("displayItems")) {
                    borrow.checkReferenceNow(users);
                    System.out.println();
                    borrow.displayItems(books, magazines, dvd, users);
                }
            }
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

