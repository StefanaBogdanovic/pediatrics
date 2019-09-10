function addNewTransaction(){
    $.confirm({
        title: 'Add new transaction',
        content: '<form action="/domain/transactions/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Transaction Type:</label>'+
        ' <input type="number" class="form-control" name="TXN_TYPE" placeholder="Transaction Type">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>PAN</label>' +
        '<input type="text" class="form-control" name="PAN" placeholder="PAN">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Acquirer BIN</label>' +
        '<input type="text" class="form-control" name="ACQ_BIN" placeholder="Acquirer BIN">' +
        '</div>'+
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction online date</label>' +
        '<input type="date" class="form-control" name="TXN_ONLINE_DATE" placeholder="Transaction online date">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction amount</label>' +
        '<input type="number" class="form-control" name="TXN_AMOUNT" placeholder="Transaction amount">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction currency</label>' +
        '<input type="text" class="form-control" name="TXN_CURRENCY" placeholder="Transaction currency">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>File</label>' +
        '<input type="number" class="form-control" name="FILE_ID" placeholder="FILE ID">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add transation</button>' +
        '</form>',

        cancel: function(){

        }
    });
}

function addNewFile() {
    $.confirm({
        title: 'Add new file',
        content: '<form action="/domain/files/insert" method="post">' +
        '<div class="form-group">'+
        '<label>File name</label>'+
        ' <input type="text" class="form-control" name="FILE_NAME" placeholder="File name">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>File size</label>' +
        '<input type="number" class="form-control" name="FILE_SIZE" placeholder="File size">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Import date</label>' +
        '<input type="date" class="form-control" name="IMPORT_DATE" placeholder="Import date">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add interest</button>' +
        '</form>',

        cancel: function(){

        }
    });

function addNewBank() {
    $.confirm({
        title: 'Add new bank',
        content: '<form action="/domain/banks/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Bank ID</label>'+
        ' <input type="number" class="form-control" name="bank_id" placeholder="Bank ID">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>Name</label>' +
        '<input type="text" class="form-control" name="name" placeholder="Name">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Account</label>' +
        '<input type="text" class="form-control" name="account" placeholder="Account">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add bank</button>' +
        '</form>',

        cancel: function(){

        }
    });
}

function addNewCustomer() {
    $.confirm({
        title: 'Add new customer',
        content: '<form action="/domain/customers/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Customer ID</label>'+
        ' <input type="number" class="form-control" name="customer_id" placeholder="Customer ID">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>Name</label>' +
        '<input type="text" class="form-control" name="name" placeholder="Name">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Address</label>' +
        '<input type="text" class="form-control" name="address" placeholder="Address">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add customer</button>' +
        '</form>',

        cancel: function(){

        }
    });
}

