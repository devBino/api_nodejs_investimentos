@extends('template.template')
@section('contentPage')

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Lançar Aportes Financeiros</h1>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-sm-12">

        <!-- Form Register -->
        <div class="row">
            <div class="col-lg-12 d-lg-block">
                <form method="post" action="/aportes-salvar">
                    
                    <input type="hidden" name="_token" value="{!! csrf_token() !!}">
                    <input type="hidden" name="id" id="id" value="">

                    <div class="p-5">

                        <div class="row">
                            
                            <div class="col-sm-6">

                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpAtivo">Ativo (*)</label>
                                        <select name="cpAtivo" id="cpAtivo" class="form-control form-control-sm" required>
                                            <option></option>
                                            @if( isset($data['ativos']) && count($data['ativos']) )
                                                @foreach( $data['ativos'] as $num => $val )
                                                    <option value="{{$val->cdAtivo}}">{{$val->nmAtivo}}</option>
                                                @endforeach
                                            @endif
                                        </select>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpValor">Valor (*)</label>
                                        <input type="number" step="0.01" name="cpValor" id="cpValor" class="form-control form-control-sm" placeholder="Ex 21,97" required>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpQtde">Quantidade (*)</label>
                                        <input type="number" name="cpQtde" min="1" max="1000" step="1" id="cpQtde" class="form-control form-control-sm" placeholder="Ex 10" required>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                    </div>
                                </div>
                                
                        
                            </div>

                            <div class="col-sm-6">
                                
                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpSubTotal">Sub Total (*)</label>
                                        <input type="text" name="cpSubTotal" id="cpSubTotal" class="form-control form-control-sm" readonly required>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpData">Data (*)</label>
                                        <input type="date" name="cpData" id="cpData" class="form-control form-control-sm" required>
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-8 mb-3 mb-sm-0">    
                                        <label for="cpTaxaRetorno">Taxa Retorno</label>
                                        <input type="number" step="0.01" name="cpTaxaRetorno" id="cpTaxaRetorno" class="form-control form-control-sm" placeholder="Ex 4,50">
                                    </div>
                                    <div class="col-sm-4 mb-3 mb-sm-0">
                                        <button class="btn btn-success mt-4 bt-novo"><i class="fas fa-check"></i></button>
                                    </div>
                                </div>

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
                        <h6 class="m-0 font-weight-bold text-primary">Aportes Realizados</h6>
                    </div>                    
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>ATIVO</th>
                                        <th>VALOR</th>
                                        <th>QUANTIDADE</th>
                                        <th>SUB.TOTAL</th>
                                        <th>DATA</th>
                                        <th>TX. RETORNO</th>
                                        <th><center>-</center></th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    @if( isset($data['aportes']) &&  count($data['aportes']) )
                                        @foreach($data['aportes'] as $num => $val)
                                            
                                            @php
                                                $dataDados = [];
                                                $dataDados[] = $val->cdAporte;
                                                $dataDados[] = $val->cdAtivo;
                                                $dataDados[] = $val->vlAporte;
                                                $dataDados[] = $val->qtde;
                                                $dataDados[] = $val->subTotal;
                                                $dataDados[] = $val->dtAporte;
                                                $dataDados[] = $val->taxaRetorno;
                                                $strDataDados = implode(",",$dataDados);
                                            @endphp

                                            <tr>
                                                <td>{{$val->cdAporte}}</td>
                                                <td>{{$val->cdAtivo}}</td>
                                                <td>R$ {{ number_format($val->vlAporte,2,',','.') }}</td>
                                                <td>{{$val->qtde}}</td>
                                                <td>R$ {{ number_format($val->subTotal,2,',','.') }}</td>
                                                <td>{{ $val->dtAporte }}</td>
                                                <td>{{ number_format($val->taxaRetorno,2,',','.') }}</td>
                                                <td><center><a href="/aportes-deletar/{{$val->cdAporte}}" class="btn btn-danger btn-sm bt-deletar"><i class="fas fa-trash"></i></a></center></td>
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

<script src="{{asset('/js/sistema/aportes.js')}}"></script>

@stop