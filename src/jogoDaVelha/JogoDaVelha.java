package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {

		Campo[][] jogo = new Campo[3][3];
		char simboloAtual = 'X';
		boolean game = true;
		String win = "";
		Scanner sc = new Scanner(System.in);

		iniciarJogo(jogo);

		while (game) {
			desenhaJogo(jogo);
			win = verificarWin(jogo);
			if (!win.equals("")) {
				System.out.printf("Jogador %s Venceu %n", win);
				break;
			}
			try {
				if (verificarJogada(jogo, jogar(sc, simboloAtual), simboloAtual)) {
					if (simboloAtual == 'X') {
						simboloAtual = 'O';
					} else {
						simboloAtual = 'X';
					}
				}
			} catch (Exception e) {
				System.out.println("Erro");
			}

		}
		System.out.println("Fim de Jogo");
	}

	public static void desenhaJogo(Campo[][] jogo) {
		limparTela();
		System.out.println("   0    1    2");
		System.out.printf("0   %c | %c | %c %n", jogo[0][0].getSimbolo(), jogo[0][1].getSimbolo(),
				jogo[0][2].getSimbolo());
		System.out.println("-----------------");
		System.out.printf("1   %c | %c | %c %n", jogo[1][0].getSimbolo(), jogo[1][1].getSimbolo(),
				jogo[1][2].getSimbolo());
		System.out.println("-----------------");
		System.out.printf("2   %c | %c | %c %n", jogo[2][0].getSimbolo(), jogo[2][1].getSimbolo(),
				jogo[2][2].getSimbolo());
	}

	public static void limparTela() {
		for (int cont = 0; cont < 30; cont++) {
			System.out.println("");
		}
	}

	public static int[] jogar(Scanner sc, char simboloAtual) {
		int p[] = new int[2];
		System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
		System.out.print("informa a linha: ");
		p[0] = sc.nextInt();
		System.out.print("informa a coluna: ");
		p[1] = sc.nextInt();
		return p;

	}

	public static void iniciarJogo(Campo[][] jogo) {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				jogo[l][c] = new Campo();
			}
		}
	}

	public static boolean verificarJogada(Campo[][] jogo, int p[], char simboloAtual) {
		if (jogo[p[0]][p[1]].getSimbolo() == ' ') {
			jogo[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;
		} else {
			return false;
		}
	}

	public static String verificarWin(Campo[][] jogo) {
		for (int i = 0; i < 3; i++) {
			if (jogo[i][0].getSimbolo() != ' ' && jogo[i][0].getSimbolo() == jogo[i][1].getSimbolo()
					&& jogo[i][0].getSimbolo() == jogo[i][2].getSimbolo()) {
				return String.valueOf(jogo[i][0].getSimbolo());
			}
		}

		for (int i = 0; i < 3; i++) {
			if (jogo[0][i].getSimbolo() != ' ' && jogo[0][i].getSimbolo() == jogo[1][i].getSimbolo()
					&& jogo[0][i].getSimbolo() == jogo[2][i].getSimbolo()) {
				return String.valueOf(jogo[0][i].getSimbolo());
			}
		}

		if (jogo[0][0].getSimbolo() != ' ' && jogo[0][0].getSimbolo() == jogo[1][1].getSimbolo()
				&& jogo[0][0].getSimbolo() == jogo[2][2].getSimbolo()) {
			return String.valueOf(jogo[0][0].getSimbolo());
		}

		if (jogo[0][2].getSimbolo() != ' ' && jogo[0][2].getSimbolo() == jogo[1][1].getSimbolo()
				&& jogo[0][2].getSimbolo() == jogo[2][0].getSimbolo()) {
			return String.valueOf(jogo[0][2].getSimbolo());
		}

		return "";
	}

}
