import java.util.ArrayList;
import java.util.List;

public class MemoryEater {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        // Alocar blocos de 1 MB até acumular cerca de 2 GB
        int blockSize = 1024 * 1024; // 1 MB
        int blocksToAllocate = 2 * 1024; // para acumular 2 GB

        try {
            for (int i = 0; i < blocksToAllocate; i++) {
                list.add(new byte[blockSize]);
                if (i % 100 == 0) {
                    System.out.println("Alocado: " + (i + 1) + " MB");
                }
                Thread.sleep(20); // Adicionado para alocar memória mais lentamente
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Erro: Memória insuficiente!");
        } catch (InterruptedException e) {
            System.err.println("Erro: A thread foi interrompida!");
        }

        System.out.println("Pressione ENTER para sair...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}
