<?php
namespace App\Http\Controllers;

use App\Http\Models\AtivoData;
use App\Http\Models\AporteData;
use Illuminate\Http\Request;

class Aporte{
    
    public function __construct(){
        AporteData::setParams();
    }

    public function index(){
        
        AtivoData::setParams();
        $data['ativos'] = AtivoData::listar()['response'];
        
        AporteData::setParams();
        $data['aportes'] = AporteData::listar()['response'];
        
        return view('aportes.index')->with(['data'=>$data]);
    }

    public function salvar(Request $request){
        if( $request->all()['id'] ){
            AporteData::alterar($request->all());
            return redirect('/aportes');
        }else{
            AporteData::salvar($request->all());
            return redirect('/aportes');
        }
    }

    public function deletar($id){
        AporteData::deletar($id);
        return redirect('/aportes');
    }
}