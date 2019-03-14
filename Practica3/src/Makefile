CC = javac
EXE = TesterCamino TesterPosada TesterExplorador EjemploDeUsoSimulacion EjemploDeUsoExploradoresBasicos

all: $(EXE)

clean: 
	rm -rf es/uam/eps/ads/p3/Classes/*.class es/uam/eps/ads/p3/Tester/*.class

$(EXE):
	@echo "Generando $@"
	$(CC) es/uam/eps/ads/p3/Tester/$@.java