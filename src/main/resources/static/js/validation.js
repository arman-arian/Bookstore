(() => {
    'use strict'

    if(!isPageValid()) {
        focusOnFirstInvalidElement();
        return;
    }
    else {
        focusOnFirstElement();
    }

    const forms = document.querySelectorAll(".needs-validation");
    Array.from(forms).forEach(form => {
        const inputs = form.getElementsByTagName("INPUT");
        for (let i = 0; i < inputs.length; i++) {
            inputs[i].oninvalid = function (e) {
                if(e.target.validity.valueMissing) {
                    showErrorMessage(e, "data-cs-empty-message");
                }
                else if(e.target.validity.tooShort || e.target.validity.tooLong) {
                    showErrorMessage(e, "data-cs-length-message");
                }
                else if(e.target.validity.typeMismatch) {
                    showErrorMessage(e, "data-cs-invalid-message");
                }
                else {
                    showCustomErrorMessage(e.target.validationMessage);
                }
            };

            if(inputs[i].type === "password" && needPasswordConfirmCheck(form)) {
                inputs[i].onkeyup = function(e) {
                    validatePassword(form, e);
                }
            }
        }

        form.onsubmit = function(e) {
            validateForm(form, e);
        }
    })
})();

function validateForm(form, e) {
    if (!form.checkValidity()) {
        e.preventDefault();
        e.stopPropagation();
        form.querySelector("input:invalid").focus();
    }

    form.classList.add("was-validated");
}

function needPasswordConfirmCheck(form) {
    const rePsw = form["repeatPassword"];
    return rePsw != null;
}

function validatePassword(form) {
    const psw = form["password"];
    const rePsw = form["repeatPassword"];

    if(rePsw == null)
        return;

    if(rePsw.value === "" && psw.value === "")
        return;

    if (rePsw.value !== "" && psw.value !== rePsw.value) {
        rePsw.setCustomValidity(rePsw.getAttribute("data-cs-confirm-message"));
        rePsw.dispatchEvent(new Event("invalid"));
    }
    else {
        rePsw.setCustomValidity("");
    }
}

function showErrorMessage(e, attr) {
    const msg = e.target.getAttribute(attr);
    if(msg != null) {
        showCustomErrorMessage(e, msg);
    }
}

function showCustomErrorMessage(e, errorMessage) {
    const element = e.target.parentNode.querySelector(".invalid-tooltip");
    if (element != null) {
        if(errorMessage) {
            element.innerHTML = errorMessage;
        }
    }
}

function isPageValid() {
    const hasError = document.getElementById("pageErrorState");
    if(hasError != null) {
        return hasError.value === "false";
    }
    else {
        return true;
    }
}

function focusOnFirstInvalidElement() {
    const form = document.querySelector('.needs-validation');
    if(form != null) {
        const element = form.querySelector(".is-invalid");
        if(element != null) {
            element.focus();
        }
    }
}

function focusOnFirstElement() {
    const form = document.querySelector('.needs-validation');
    if(form != null) {
        const element = form.querySelector("input.form-control[type=text]");
        if(element != null) {
            element.focus();
        }
    }
}
