package fr.univartois.butinfo.ihm;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HelloController {
	private int[][] tab = new int[4][4];
	private Label[][] label = new Label[4][4];
	boolean victoire=false;
	boolean defaite=false;
	
    @FXML
    private Label welcomeText;

    @FXML
    private Label c00;

    @FXML
    private Label c01;

    @FXML
    private Label c02;

    @FXML
    private Label c03;

    @FXML
    private Label c10;

    @FXML
    private Label c11;

    @FXML
    private Label c12;

    @FXML
    private Label c13;

    @FXML
    private Label c20;

    @FXML
    private Label c21;

    @FXML
    private Label c22;

    @FXML
    private Label c23;

    @FXML
    private Label c30;

    @FXML
    private Label c31;

    @FXML
    private Label c32;

    @FXML
    private Label c33;
    
    @FXML
    private ProgressBar progressbar;
    
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Partie lancée");
        initialize();
    }
    
    @FXML
    void initialize() {
        defaite=false;
    	victoire=false;
    	for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            	tab[i][j]=0;
            }
        }
        int init=2;
        Random r = new Random();
        while (init>0) {
        	for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                if (init!=0) {
		                	if (tab[i][j]==0) {
		                	if (r.nextInt(1, 11)>8) {
		                		if (r.nextInt(1,3)>=2) {
		                			int tmp=i;
		                			i=j;
		                			j=tmp;
		                		}
			                	if (r.nextInt(1, 11)>8) {
			                    	tab[i][j]=4;
			                    	init--;
			                    }
			                	else {
			                		tab[i][j]=2;
			                		init--;
			                	}
		                	
		                	}
		                }
	                }	
	            }
        	}
        }
        label[0][0]=c00;
        label[0][1]=c01;
        label[0][2]=c02;
        label[0][3]=c03;
        label[1][0]=c10;
        label[1][1]=c11;
        label[1][2]=c12;
        label[1][3]=c13;
        label[2][0]=c20;
        label[2][1]=c21;
        label[2][2]=c22;
        label[2][3]=c23;
        label[3][0]=c30;
        label[3][1]=c31;
        label[3][2]=c32;
        label[3][3]=c33;
        maj();
    }
    
    @FXML
    void maj() {
    	for (int i=0;i<4;i++) {
    		for (int j = 0; j < 4; j++) {
    			if (tab[i][j]!=0) {
    				label[i][j].setText( Integer.toString(tab[i][j]));
    			}
    			else if(!label[i][j].getText().equals(Integer.toString(0))) {
    				label[i][j].setText("");
    			}
    		}	
    	}
    }
    
    @FXML
    void ajoutRound() {
    	if (!defaite) {
    		int init=1;
	    	Random r = new Random();
	        while (init>0) {
	        	for (int i = 0; i < 4; i++) {
		            for (int j = 0; j < 4; j++) {
		                if (init!=0) {
		                	if (tab[i][j]==0) {
		                		if (r.nextInt(1, 11)>8) {
				                	if (r.nextInt(1, 11)>8) {
				                    	tab[i][j]=4;
				                    	init--;
				                    }
				                	else {
				                		tab[i][j]=2;
				                		init--;
				                	}
		                		}
		                	}
		                }
		            }
	        	}
	        }
    	}
    }
    
    @FXML
    void victoire() {
    	int min=2;
    	for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(tab[i][j]>min) {
                	min=tab[i][j];
                }
            	if (tab[i][j]==2048){
                	welcomeText.setText("Victoire !");
                	victoire = true;
                }
            }
        }
    	switch(min) {
    	case 2 :
    		progressbar.setProgress(0.09);
    		break;
    	case 4 :
    		progressbar.setProgress(0.18);
    		break;
    	case 8 :
    		progressbar.setProgress(0.27);
    		break;
    	case 16 :
    		progressbar.setProgress(0.36);
    		break;
    	case 32 :
    		progressbar.setProgress(0.45);
    		break;
    	case 64 :
    		progressbar.setProgress(0.54);
    		break;
    	case 128 :
    		progressbar.setProgress(0.63);
    		break;
    	case 256 :
    		progressbar.setProgress(0.72);
    		break;
    	case 512 :
    		progressbar.setProgress(0.81);
    		break;
    	case 1024 :
    		progressbar.setProgress(0.90);
    		break;
    	case 2048 :
    		progressbar.setProgress(1);
    		break;
    	}
    }
    
    @FXML
    void defaite() {
    	int nbCaseLibre=0;
    	for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tab[i][j]==0){
                	nbCaseLibre++;
                }
            }
        }
    	if (nbCaseLibre==0) {
    		welcomeText.setText("Defaite :(");
    		defaite=true;
    	}
    }
    
    @FXML
    void deplacementB() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (tab[i][j] != 0) {
                    int k = i;
                    while (k < 3 && tab[k + 1][j] == 0) {
                        tab[k + 1][j] = tab[k][j];
                        tab[k][j] = 0;
                        k++;
                    }
                    if (k < 3 && tab[k + 1][j] == tab[k][j]) {
                        tab[k + 1][j] *= 2;
                        tab[k][j] = 0;
                    }
                }
            }
        }
        maj();
    }

    @FXML
    void deplacementH() {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tab[i][j] != 0) {
                    int k = i;
                    while (k > 0 && tab[k - 1][j] == 0) {
                        tab[k - 1][j] = tab[k][j];
                        tab[k][j] = 0;
                        k--;
                    }
                    if (k > 0 && tab[k - 1][j] == tab[k][j]) {
                        tab[k - 1][j] *= 2;
                        tab[k][j] = 0;
                    }
                }
            }
        }
        maj();
    }

    @FXML
    void deplacementG() {
        for (int j = 1; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (tab[i][j] != 0) {
                    int k = j;
                    while (k > 0 && tab[i][k - 1] == 0) {
                        tab[i][k - 1] = tab[i][k];
                        tab[i][k] = 0;
                        k--;
                    }
                    if (k > 0 && tab[i][k - 1] == tab[i][k]) {
                        tab[i][k - 1] *= 2;
                        tab[i][k] = 0;
                    }
                }
            }
        }
        maj();
    }

    @FXML
    void deplacementD() {
        for (int j = 2; j >= 0; j--) {
            for (int i = 0; i < 4; i++) {
                if (tab[i][j] != 0) {
                    int k = j;
                    while (k < 3 && tab[i][k + 1] == 0) {
                        tab[i][k + 1] = tab[i][k];
                        tab[i][k] = 0;
                        k++;
                    }
                    if (k < 3 && tab[i][k + 1] == tab[i][k]) {
                        tab[i][k + 1] *= 2;
                        tab[i][k] = 0;
                    }
                }
            }
        }
        maj();
    }

    @FXML
    protected void OnMouvmentButtonClickH() {
    	if (!victoire && !defaite) {
    		welcomeText.setText("↑");
    		deplacementG();
    		ajoutRound();
    		maj();
    		victoire();
    		defaite();
    	}
    }
    
    @FXML
    protected void OnMouvmentButtonClickB() {
    	if (!victoire && !defaite) {
    		welcomeText.setText("↓");
    		deplacementD();
    		ajoutRound();
    		maj();
    		victoire();
    		defaite();
    	}
    }
    
    @FXML
    protected void OnMouvmentButtonClickG() {
    	if (!victoire && !defaite) {
    		welcomeText.setText("←");
    		deplacementH();
    		ajoutRound();
    		maj();
    		victoire();
    		defaite();
    	}
    }
    
    @FXML
    protected void OnMouvmentButtonClickD() {
    	if (!victoire && !defaite) {
    		welcomeText.setText("→");
    		deplacementB();
    		ajoutRound();
    		maj();
    		victoire();
    		defaite();
    	}
    }
}