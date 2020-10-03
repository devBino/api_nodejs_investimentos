@extends('template.template')
@section('contentPage')

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Cadastro de Ativos Financeiros</h1>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-sm-12">

        <!-- Form Register -->
        <div class="row">
            <div class="col-lg-12 d-lg-block">
                <form method="post" action="/ativos-salvar">
                    
                    <input type="hidden" name="_token" value="{!! csrf_token() !!}">
                    <input type="hidden" name="id" id="id" value="">

                    <div class="p-5">
                    
                        <div class="form-group row">
                            <div class="col-sm-2 mb-3 mb-sm-0">    
                                <label for="cpNomeAtivo">Nome Ativo</label>
                            </div>
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" name="cpNomeAtivo" id="cpNomeAtivo" class="form-control form-control-sm" placeholder="Ex Tesouro Selic" required autofocus="true" autocomplete="off">
                            </div>
                            <div class="col-sm-4 mb-3 mb-sm-0">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-2 mb-3 mb-sm-0">    
                                <label for="cpValor">Valor Cota</label>
                            </div>
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="number" step="0.01" name="cpValor" id="cpValor" class="form-control form-control-sm" placeholder="Ex 10,99" required>
                            </div>
                            <div class="col-sm-4 mb-3 mb-sm-0">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-2 mb-3 mb-sm-0">    
                                <label for="cpValor">Tipo Ativo</label>
                            </div>
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <select name="cpTipo" id="cpTipo" class="form-control form-control-sm" required>
                                    <option></option>
                                    @if( isset($data['tipos']) && count($data['tipos']) )
                                        @foreach( $data['tipos'] as $num => $val )
                                            <option value="{{$val->cdTipo}}">{{$val->nmTipo}}</option>
                                        @endforeach
                                    @endif
                                </select>
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
                        <h6 class="m-0 font-weight-bold text-primary">Ativos Financeiros Cadastrados</h6>
                    </div>                    
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>ATIVO</th>
                                        <th>VALOR</th>
                                        <th>TIPO ATIVO</th>
                                        <th colspan=2><center>-</center></th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    @if( isset($data['ativos']) &&  count($data['ativos']) )
                                        @foreach($data['ativos'] as $num => $val)
                                            
                                            @php
                                                $dataDados = [];
                                                $dataDados[] = $val->cdAtivo;
                                                $dataDados[] = $val->nmAtivo;
                                                $dataDados[] = $val->vlAtivo;
                                                $dataDados[] = $val->cdTipo;
                                                $strDataDados = implode(",",$dataDados);
                                            @endphp

                                            <tr>
                                                <td>{{$val->cdAtivo}}</td>
                                                <td>{{$val->nmAtivo}}</td>
                                                <td>R$ {{ number_format($val->vlAtivo,2,',','.') }}</td>
                                                <td>{{$val->cdTipo}}</td>
                                                <td><center><span class="btn btn-info btn-sm bt-editar" data-dados="{{$strDataDados}}"><i class="fas fa-edit"></i></span></center></td>
                                                <td><center><a href="/ativos-deletar/{{$val->cdAtivo}}" class="btn btn-danger btn-sm bt-deletar"><i class="fas fa-trash"></i></a></center></td>
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

<script src="{{asset('/js/sistema/ativos.js')}}"></script>

@stop