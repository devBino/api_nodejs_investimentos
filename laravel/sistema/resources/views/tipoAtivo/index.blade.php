@extends('template.template')
@section('contentPage')

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Cadastro de Tipos de Ativos Financeiros</h1>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-sm-12">

        <!-- Form Register -->
        <div class="row">
            <div class="col-lg-12 d-lg-block">
                <form method="post" action="/tipo-ativos-salvar">
                    
                    <input type="hidden" name="_token" value="{!! csrf_token() !!}">
                    <input type="hidden" name="id" id="id" value="">

                    <div class="p-5">
                    
                        <div class="form-group row">
                            <div class="col-sm-2 mb-3 mb-sm-0">    
                                <label for="cpNomeTipo">Tipo Ativo</label>
                            </div>
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" name="cpNomeTipo" id="cpNomeTipo" class="form-control form-control-sm" placeholder="Ex Renda Fixa" required autofocus="true"  autocomplete="off">
                            </div>
                            <div class="col-sm-4 mb-3 mb-sm-0">
                                <button class="btn btn-success btn-sm bt-novo"><i class="fas fa-check"></i></button>
                            </div>
                        </div>
                    </div>    
                </form>
            </div>
        </div>

        <!-- Data Table -->
        <div class="row">
            <div class="col-sm-12">
            
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Tipos de Ativos Financeiros Cadastrados</h6>
                    </div>                    
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>TIPO ATIVO</th>
                                        <th colspan=2><center>-</center></th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    @if( isset($data['tipos']) &&  count($data['tipos']) )
                                        @foreach($data['tipos'] as $num => $val)
                                            
                                            @php
                                                $dataDados = [];
                                                $dataDados[] = $val->cdTipo;
                                                $dataDados[] = $val->nmTipo;
                                                $strDataDados = implode(",",$dataDados);
                                            @endphp

                                            <tr>
                                                <td>{{$val->cdTipo}}</td>
                                                <td>{{$val->nmTipo}}</td>
                                                <td><center><span class="btn btn-info btn-sm bt-editar" data-dados="{{$strDataDados}}"><i class="fas fa-edit"></i></span></center></td>
                                                <td><center><a href="/tipo-ativos-deletar/{{$val->cdTipo}}" class="btn btn-danger btn-sm bt-deletar"><i class="fas fa-trash"></i></a></center></td>
                                            </tr>
                                        @endforeach
                                    @endif
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<script src="{{asset('/js/sistema/tipoAtivos.js')}}"></script>

@stop