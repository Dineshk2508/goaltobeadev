var g_FocusElementStyle = "2px solid #000000";
var g_UnFocusElementStyle = "2px solid #cbcbcb";
var g_FocusBackColor = "#ffc";
var g_reEmail = /^[\w\.=-]+\@[\w\.-]+\.[a-z]{2,4}$/;
var g_invalidFields = 0;

function initFormElements(sValidElems) {
    var inputElems = document.getElementsByTagName('textarea');
    for (var i = 0; i < inputElems.length; i++) {
        com_joemarini.EVENTS.addEventHandler(inputElems[i], 'focus', highlightFormElement, false);
        com_joemarini.EVENTS.addEventHandler(inputElems[i], 'blur', unHighlightFormElement, false);
    }
    /* add the code for the input elements */
    inputElems = document.getElementsByTagName('input');
    for (var i = 0; i < inputElems.length; i++) {
        if (sValidElems.indexOf(inputElems[i].getAttribute('type')) != -1) {
            com_joemarini.EVENTS.addEventHandler(inputElems[i], 'focus', highlightFormElement, false);
            com_joemarini.EVENTS.addEventHandler(inputElems[i], 'blur', unHighlightFormElement, false);
        }
    }

    /* add the reset and submit handlers */
    com_joemarini.EVENTS.addEventHandler(document.getElementById('form1'), 'reset', function() {
        document.getElementsByTagName('input')[0].focus();
        for (var i = 0; i < document.getElementsByTagName('label').length; i++)
            document.getElementsByTagName('label')[i].className = "required";
    }, false);
    com_joemarini.EVENTS.addEventHandler(document.getElementById('form1'), 'submit', validateAllFields, false);
    
    /* add the default focus handler */
    document.getElementsByTagName('input')[0].focus();

    /* add the event handlers for validation */
    com_joemarini.EVENTS.addEventHandler(document.forms[0].subject,'blur',validateSubject,false);
    com_joemarini.EVENTS.addEventHandler(document.forms[0].address, 'blur', validateAddress, false);
    com_joemarini.EVENTS.addEventHandler(document.forms[0].message, 'blur', validateMsg, false);
}


function getLabelByID(idStr) {
    var formLabels = document.getElementsByTagName('label');
    var attrName = window.event ? "htmlFor" : "for";
    for (var i = 0; i < formLabels.length; i++) {
        if (formLabels[i].getAttribute(attrName) == idStr)
            return formLabels[i];
    }
    return null;
}

function highlightFormElement(evt) {
    var elem = com_joemarini.EVENTS.getEventTarget(evt);
    if (elem != null) {
        elem.style.border = g_FocusElementStyle;
        elem.style.backgroundColor = g_FocusBackColor;
    }
}

function unHighlightFormElement(evt) {
    var elem = com_joemarini.EVENTS.getEventTarget(evt);
    if (elem != null) {
        elem.style.border = g_UnFocusElementStyle;
        elem.style.backgroundColor = "";
    }
}

function validateSubject() {
    var formField = document.getElementById('subject');
    var ok = (formField.value != null && formField.value.length != 0);
    var theLabel = getLabelByID('subject');
    if (theLabel != null) {
        if (ok) {
            theLabel.className = "validated";
        }
        else
            theLabel.className = "invalid";
    }
    return ok;
}

function validateAddress() {
    var formField = document.getElementById('address');
    var ok = (formField.value.length != 0 && g_reEmail.test(formField.value));
    var theLabel = getLabelByID('address');
    if (theLabel != null) {
        if (ok) {
            theLabel.className = "validated";
        }
        else
            theLabel.className = "invalid";
    }
    return ok;
}

function validateMsg() {
    var formField = document.getElementById('message');
    var ok = (formField.value != null && formField.value.length != 0);
    var theLabel = getLabelByID('message');
    if (theLabel != null) {
        if (ok) {
            theLabel.className = "validated";
        }
        else
            theLabel.className = "invalid";
    }
    return ok;
}

function validateAllFields(e) {
    // need to do it this way to make sure all the functions execute
    var bOK = validateSubject();
    bOK &= validateAddress();
    bOK &= validateMsg();

    if (!bOK) {
        alert("The fields that are marked bold and red are required. Please supply valid\nvalues for these fields before sending.");
        com_joemarini.EVENTS.preventDefault(e);
    }
}

com_joemarini.EVENTS.addEventHandler(window, "load", function() { initFormElements('text'); }, false);

