package repositories;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TableOrdem {

	private DefaultTableModel modelOrdenada;
	private DefaultTableModel modelAux;
	private ArrayList<Integer> indicesChecados;
	private String[] colunas;
	
	public TableOrdem(DefaultTableModel paramModel, String[] paramColunas) {
		modelAux = paramModel;
		indicesChecados = new ArrayList<Integer>();
		colunas = paramColunas;
	}
	
	public void setModels(DefaultTableModel paramModel) {
		modelAux = paramModel;
		indicesChecados = new ArrayList<Integer>();
	}
	
	public DefaultTableModel getModel() {
		return modelOrdenada;
	}
	
	public void modelAsc(int coluna) {
		try {
			
			indicesChecados.clear();
			
			modelOrdenada = new DefaultTableModel();
			modelOrdenada.setColumnIdentifiers(colunas);
			
			while( indicesChecados.size() < modelAux.getRowCount() ) {
				setIndicesMinValue(coluna);
			}
			
			for(int i=0;i<indicesChecados.size();i++) {
				
				String[] objRow = new String[ modelAux.getColumnCount() ];
				
				for(int j=0;j<modelAux.getColumnCount();j++) {
					if( modelAux.getValueAt( indicesChecados.get(i), j ) != null ) {
						objRow[j] = modelAux.getValueAt( indicesChecados.get(i), j ).toString();
					}
				}
				
				modelOrdenada.addRow(objRow);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modelDesc(int coluna) {
		try {
			
			indicesChecados.clear();
			
			modelOrdenada = new DefaultTableModel();
			modelOrdenada.setColumnIdentifiers(colunas);
			
			while( indicesChecados.size() < modelAux.getRowCount() ) {
				setIndicesMaxValue(coluna);
			}
			
			for(int i=0;i<indicesChecados.size();i++) {
			
				String[] objRow = new String[ modelAux.getColumnCount() ];
				
				for(int j=0;j<modelAux.getColumnCount();j++) {
					if( modelAux.getValueAt( indicesChecados.get(i), j ) != null ) {
						objRow[j] = modelAux.getValueAt( indicesChecados.get(i), j ).toString();
					}
				}
				
				modelOrdenada.addRow(objRow);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setIndicesMaxValue(int coluna) {
		
		Double maxValue = 0.00;
		int indiceMaxValue = -1;
		
		for( int i=0; i<modelAux.getRowCount(); i++ ) {

			if( indicesChecados.contains(i) ) {
				continue;
			}
			
			Double valorTeste = Double.parseDouble( modelAux.getValueAt(i,coluna).toString().replace("R$","").replace(",",".") );
			
			if( valorTeste > maxValue ) {
				maxValue = valorTeste;
				indiceMaxValue = i;
			}
			
		}
		
		indicesChecados.add(indiceMaxValue);
		
	}
	
	public void setIndicesMinValue(int coluna) {
		
		Double minValue = 999999999999.00;
		int indiceMinValue = -1;
		
		for( int i=0; i<modelAux.getRowCount(); i++ ) {
		
			if( indicesChecados.contains(i) ) {
				continue;
			}
			
			Double valorTeste = Double.parseDouble( modelAux.getValueAt(i,coluna).toString().replace("R$","").replace(",",".") );
			
			if( valorTeste < minValue ) {
				minValue = valorTeste;
				indiceMinValue = i;
			}
			
		}
		
		indicesChecados.add(indiceMinValue);
		
	}
	
}
