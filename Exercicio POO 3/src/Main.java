import com.exercicio3.User;
import com.exercicio3.UserConn;

public class Main {
    public static void main(String[] args) {

        User usr = new User();

        usr.setNome("Adelarde Pinto");
        usr.setCpf("204.904.304-11");
        usr.setEmail("adelardepinto@outlook.com");
        usr.setPasswd("54321");
        usr.setIdade((byte) 75);

        System.out.println(new UserConn().getUsers());

    }
}