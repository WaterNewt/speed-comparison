import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hashBruteforce {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String target = "23379f40a2d9beb40a732cd15acc3093";
        String wordlist = "top-3000000.txt";
        String[] passwords = null;
        try {
			passwords = file2array(wordlist);
		} catch (IOException e) {
			e.printStackTrace();
		}
        for(String i : passwords) {
        	String hashed_pass = string2md5(i);
        	if(hashed_pass.equals(target)) {
        		System.out.println("Found the password.\nPassword is: "+i);
                long duration = System.currentTimeMillis() - start;
                System.out.println("Duration: "+duration+" ms");
        		System.exit(0);
        	}
        }
    }

    public static String string2md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] file2array(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines.toArray(new String[0]);
    }
}
