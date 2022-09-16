import java.util.Scanner;
import java.text.DecimalFormat; 
 

class mont {
    int tempo,modelo;
    double rate,aporte,inicial,vfinal,imposto,investido;
    String lucro,liquido,saque;
    
    void Investments() {
        if (modelo==1) {
            System.out.println("Em " + tempo + " anos, o seu investimento inicial de " + inicial + " com aporte mensal de " + aporte + " e rendimento de " + rate + "% vai valer " + InvestPorAno(tempo));
            System.out.println("Nesse tempo, o total investido foi de " + investido + " e o imposto de renda foi de " + imposto + "%, sendo assim, seu lucro liquido foi de " + lucro);
            System.out.println("No final, a quantia de " + saque + " estará disponível para saque.");
        }
        else {
            System.out.println("Em " + tempo + " meses, o seu investimento inicial de " + inicial + " com aporte mensal de " + aporte + " e rendimento de " + rate + "% vai valer " + InvestPorMes(tempo));
            System.out.println("Nesse tempo, o total investido foi de " + investido + " e o imposto de renda foi de " + imposto + "%, sendo assim, seu lucro liquido foi de " + lucro);
            System.out.println("No final, a quantia de " + saque + " estará disponível para saque.");
        }
    }
    String InvestPorMes(int temp) {
        vfinal = inicial;
        investido = inicial;
        for (int i=0;i<temp;i++) {
            vfinal *=1+(rate/100);
            investido +=aporte;
            vfinal +=aporte; 
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        lucro = df.format(vfinal-investido);
        liquido = df.format((vfinal-investido)*(100-imposto)/100);
        saque = df.format(investido+(vfinal-investido)*(100-imposto)/100);
        return df.format(vfinal); 
    }
    String InvestPorAno(int temp) {
        vfinal = inicial;
        investido = inicial;
        for (int i=0;i<temp;i++) {
            for (int j=0;j<12;j++) {
                vfinal *=1+(rate/100);
                investido +=aporte;
                vfinal +=aporte;
            }
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        lucro = df.format(vfinal-investido);
        liquido = df.format((vfinal-investido)*(100-imposto)/100);
        saque = df.format(investido+(vfinal-investido)*(100-imposto)/100);
        return df.format(vfinal); 
    }

    mont(int nTempo, int nModelo, double nRate, double nAporte, double nInicial, double nImposto) {
        inicial = nInicial;
        aporte = nAporte;
        rate = nRate;
        modelo = nModelo;
        tempo = nTempo;
        imposto = nImposto;
    }
}

public class invest {
    public static void main(String args[]) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Escolha o modelo de rendimento [digite 1 para ano ou 0 para mes]:");
        int model = scan.nextInt();
        System.out.println("Digite o tempo que deseja manter o investimento (em meses ou em anos, de acordo com o modelo):");
        int temp = scan.nextInt();
        System.out.println("Digite a taxa de rendimento mensal do investimento (ex: 1,7):");
        double rate = scan.nextDouble();
        System.out.println("Digite o aporte mensal que será feito no futuro:");
        double aporte = scan.nextDouble();
        System.out.println("Digite o montante inicial do investimento:");
        double inicial = scan.nextDouble();
        System.out.println("Digite o Imposto de Renda sobre o lucro:");
        double imposto = scan.nextDouble();


        mont myP = new mont(temp,model,rate,aporte,inicial,imposto);
        myP.Investments();
    }
}
