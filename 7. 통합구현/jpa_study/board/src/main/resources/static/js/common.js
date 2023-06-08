const commonLib = {

};

window.addEventListener("DOMContentLoaded", function() {
    const searchAddressEls = document.getElementsByClassName("search_address");
    for (const el of searchAddressEls) {
        el.addEventListener("click", function() {
            const dataset = this.dataset;
            new daum.Postcode({
                oncomplete: function(data) {
                    if (typeof searchAddressCallback == 'function') {   // searchAddressCallback instanceof function
                        searchAddressCallback(data);
                        return;
                    }
                    const addressId = dataset.addressId;
                    const zipcodeId = dataset.zipcodeId;
                    if (!addressId || !zipcodeId) {
                        return;
                    }

                    const zipcodeEl = document.getElementsById(zipcodeId);
                    const addressEl = document.getElementsById(addressId);
                    if (zipcodeEl) zipcodeEl.value = data.zonecode;
                    if (addressEl) addressEl.value = data.roadAddress;
                }
            }).open();
        });
    }
});
