function PagedTable(tableObj, pageSize)
{
	this._oTableObj = tableObj;
	this._iPageSize = pageSize;
	this._iCurPage = 0;
	
	// store aside the rows and the page size
	this._oTBody = this._oTableObj.getElementsByTagName("tbody")[0];
	var oRows = this._oTBody.getElementsByTagName("tr");
	this._aRows = new Array(oRows.length);
	for (var i=0; i < oRows.length; i++) {
		this._aRows[i] = oRows[i].cloneNode(true);
	}
	this._iRowCount = this._aRows.length;
	
	if (this._iRowCount < this._iPageSize)
		this._iPageSize = this._iRowCount;
		
	this._iNumPages = Math.ceil(this._iRowCount / this._iPageSize);
	
	// break the table up into pages
	this.goToPage(0);
}
PagedTable.prototype.lastPage = function() {
	this._iCurPage = this._iNumPages-1;
	this.goToPage(this._iCurPage);
}
PagedTable.prototype.firstPage = function () {
	this._iCurPage=0;
	this.goToPage(this._iCurPage);
}
PagedTable.prototype.nextPage = function() {
	this._iCurPage++;
	this.goToPage(this._iCurPage);
}
PagedTable.prototype.prevPage = function () {
	this._iCurPage--;
	this.goToPage(this._iCurPage);
}
PagedTable.prototype.goToPage = function(iPageNum) {
	if (iPageNum < 0)
		iPageNum = 0;
	else if (iPageNum > this._iNumPages-1)
		iPageNum = this._iNumPages-1;
	this._iCurPage = iPageNum;
	
	var oNewTBody = document.createElement("tbody");
	var startRow = iPageNum * this._iPageSize;
	var endRow = startRow + this._iPageSize;
	if (endRow > this._iRowCount)
		endRow = this._iRowCount;
	for (var i=startRow; i < endRow; i++) {
		oNewTBody.appendChild(this._aRows[i]);
	}
	
	// replace the current table body with the newly constructed one
	this._oTableObj.removeChild(this._oTBody);
	this._oTBody = oNewTBody;
	this._oTableObj.appendChild(this._oTBody);
}
