document.addEventListener('DOMContentLoaded', function() {
    const apiUrl = 'http://localhost:8080/api/v1/karyawan';
    const karyawanTableBody = document.querySelector('#karyawanTable tbody');
    const karyawanForm = document.querySelector('#karyawanForm');
    const karyawanIdInput = document.querySelector('#karyawanId');
    const namaInput = document.querySelector('#nama');
    const tglLahirInput = document.querySelector('#tgl_lahir');
    const statusInput = document.querySelector('#status');

    function loadKaryawan() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                karyawanTableBody.innerHTML = '';
                data.forEach(karyawan => {
                    const row = karyawanTableBody.insertRow();
                    row.innerHTML = `
                        <td>${karyawan.id}</td>
                        <td>${karyawan.nama}</td>
                        <td>${karyawan.tglLahir}</td>
                        <td>${karyawan.status === 1 ? 'Active' : 'Non-active'}</td>
                        <td>
                            <button onclick="editKaryawan(${karyawan.id})">Edit</button>
                            <button onclick="deleteKaryawan(${karyawan.id})">Delete</button>
                        </td>
                    `;
                });
            });
    }

    karyawanForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const karyawanId = karyawanIdInput.value;
        const karyawanData = {
            nama: namaInput.value,
            tglLahir: tglLahirInput.value,
            status: statusInput.value
        };

        const fetchOptions = {
            method: karyawanId ? 'PUT' : 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(karyawanData)
        };

        const endpoint = karyawanId ? `${apiUrl}/${karyawanId}` : apiUrl;

        fetch(endpoint, fetchOptions)
            .then(response => response.json())
            .then(() => {
                resetForm();
                loadKaryawan();
            });
    });

    window.editKaryawan = function(id) {
        fetch(`${apiUrl}/${id}`)
            .then(response => response.json())
            .then(karyawan => {
                karyawanIdInput.value = karyawan.id;
                namaInput.value = karyawan.nama;
                tglLahirInput.value = karyawan.tglLahir;
                statusInput.value = karyawan.status;
            });
    };

    window.deleteKaryawan = function(id) {
        fetch(`${apiUrl}/${id}`, { method: 'DELETE' })
            .then(() => loadKaryawan());
    };

    function resetForm() {
        karyawanForm.reset();
        karyawanIdInput.value = '';
    }

    loadKaryawan();
});