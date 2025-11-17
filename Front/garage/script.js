// Precios de los espacios (como fallback)
const prices = {
    normal: 1200,
    premium: 2500,
    moto: 800
};

// Variables de estado
let selectedSpaces = [];
let currentFloor = 0;
let selectedDate = null;
let garageData = [];

// Función para verificar autenticación al cargar
function verificarAutenticacion() {
    const user = JSON.parse(sessionStorage.getItem("cliente"));
    const perfilBtn = document.getElementById("perfilBtn");

    if (user && user.id) {
        perfilBtn.textContent = `${user.nombre} ${user.apellido}`;
        perfilBtn.classList.remove("btn-outline-light");
        perfilBtn.classList.add("btn-success");
        perfilBtn.style.whiteSpace = "nowrap";
        perfilBtn.removeAttribute("data-bs-toggle");
        perfilBtn.removeAttribute("data-bs-target");
        perfilBtn.onclick = () => window.location.href = "../Perfil/perfil.html";
        console.log('✅ Usuario autenticado:', user.nombre, user.apellido);
    } else {
        perfilBtn.textContent = "Registrarse / Iniciar sesión";
        perfilBtn.classList.remove("btn-success");
        perfilBtn.classList.add("btn-outline-light");
        perfilBtn.setAttribute("data-bs-toggle", "modal");
        perfilBtn.setAttribute("data-bs-target", "#loginModal");
        perfilBtn.onclick = null;
        console.log('❌ Usuario no autenticado');
    }
}

// Función para obtener el ID del cliente
function obtenerClienteId() {
    const user = JSON.parse(sessionStorage.getItem("cliente"));
    
    console.log('🔍 Verificando autenticación...', user);
    
    if (!user || !user.id) {
        mostrarModalLogin();
        throw new Error('Usuario no autenticado');
    }
    
    console.log('👤 Cliente autenticado:', user.nombre, user.apellido, 'ID:', user.id);
    return user.id;
}

// Función para mostrar modal de login
function mostrarModalLogin() {
    const modal = new bootstrap.Modal(document.getElementById('loginRequiredModal'));
    modal.show();
    setTimeout(() => {
        redirectToLogin();
    }, 3000);
}

// Función para redirigir al login
function redirectToLogin() {
    window.location.href = "../Login/login.html";
}

// FUNCIÓN CORREGIDA: Cargar datos del garage desde Spring Boot
async function loadGarageData() {
    try {
        console.log('Cargando datos del garage desde Spring Boot...');
        
        const response = await fetch('http://localhost:8081/api/garage/6');
        
        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }
        
        const garage = await response.json();
        console.log('✅ Datos RAW del backend:', garage);
        
        // Convertir la estructura
        garageData = convertGarageStructure(garage);
        console.log('✅ Datos convertidos para frontend:', garageData);
        
        updateFloorSelector();
        renderGarage();
        
    } catch (error) {
        console.error('Error cargando datos del garage:', error);
        useMockData();
    }
}

// FUNCIÓN CORREGIDA: Convertir estructura del backend
function convertGarageStructure(garageApi) {
    console.log('🔧 Convirtiendo estructura del backend...', garageApi);
    
    if (!garageApi || !garageApi.pisosDetalle) {
        console.error('Estructura inesperada:', garageApi);
        return [];
    }
    
    return garageApi.pisosDetalle.map(piso => ({
        floor: piso.nombre || `Piso ${piso.numeroPiso}`,
        rows: organizeSpacesIntoRows(piso.espacios || [])
    }));
}

// FUNCIÓN CORREGIDA: Organizar espacios en filas
function organizeSpacesIntoRows(espacios) {
    const rows = [];
    let currentRow = [];
    
    console.log('📦 Organizando espacios:', espacios);
    
    if (!espacios || espacios.length === 0) {
        return [];
    }
    
    // Ordenar espacios por número
    espacios.sort((a, b) => a.numero - b.numero);
    
    // Crear filas de máximo 5 espacios
    espacios.forEach((espacio, index) => {
        currentRow.push({
            num: espacio.numero,
            type: mapTipoToFrontend(espacio.tipo),
            occupied: espacio.ocupado || espacio.estado !== 'disponible',
            id: espacio.id,
            precio: espacio.precio || calculatePriceFromType(espacio.tipo)
        });
        
        // Crear nueva fila cada 5 espacios o al final
        if ((index + 1) % 5 === 0 || index === espacios.length - 1) {
            rows.push([...currentRow]);
            currentRow = [];
        }
    });
    
    console.log('🏗️ Filas organizadas:', rows);
    return rows;
}

// Función para calcular precio basado en tipo
function calculatePriceFromType(tipo) {
    const prices = {
        'auto': 1200,
        'premium': 2500,
        'moto': 800
    };
    return prices[tipo] || 1200;
}

// Mapear tipos del backend al frontend
function mapTipoToFrontend(tipoBD) {
    const mapping = {
        'auto': 'normal',
        'premium': 'premium', 
        'moto': 'moto'
    };
    return mapping[tipoBD] || 'normal';
}

// Usar datos mock cuando el backend no esté disponible
function useMockData() {
    console.log('🔄 Usando datos mock para desarrollo...');
    garageData = getMockGarageData();
    updateFloorSelector();
    renderGarage();
    
    if (!sessionStorage.getItem('mockDataShown')) {
        alert('🔧 Modo desarrollo: Usando datos de prueba. El backend no está disponible.');
        sessionStorage.setItem('mockDataShown', 'true');
    }
}

// Datos mock realistas
function getMockGarageData() {
    return [
        {
            floor: "Planta Baja – Acceso Principal",
            rows: [
                [
                    { num: 1, type: 'premium', occupied: false, id: 101 },
                    { num: 2, type: 'premium', occupied: true, id: 102 },
                    { num: 3, type: 'premium', occupied: false, id: 103 },
                    { num: 4, type: 'premium', occupied: false, id: 104 },
                    { num: 5, type: 'premium', occupied: true, id: 105 }
                ],
                [
                    { num: 6, type: 'normal', occupied: false, id: 106 },
                    { num: 7, type: 'normal', occupied: false, id: 107 },
                    { num: 8, type: 'normal', occupied: true, id: 108 },
                    { num: 9, type: 'normal', occupied: false, id: 109 },
                    { num: 10, type: 'normal', occupied: false, id: 110 }
                ],
                [
                    { num: 11, type: 'moto', occupied: false, id: 111 },
                    { num: 12, type: 'moto', occupied: false, id: 112 },
                    { num: 13, type: 'moto', occupied: true, id: 113 },
                    { num: 14, type: 'moto', occupied: false, id: 114 }
                ]
            ]
        },
        {
            floor: "Primer Nivel – Zona Premium", 
            rows: [
                [
                    { num: 15, type: 'premium', occupied: false, id: 115 },
                    { num: 16, type: 'premium', occupied: false, id: 116 },
                    { num: 17, type: 'premium', occupied: true, id: 117 },
                    { num: 18, type: 'premium', occupied: false, id: 118 },
                    { num: 19, type: 'premium', occupied: false, id: 119 }
                ],
                [
                    { num: 20, type: 'normal', occupied: false, id: 120 },
                    { num: 21, type: 'normal', occupied: false, id: 121 },
                    { num: 22, type: 'normal', occupied: true, id: 122 },
                    { num: 23, type: 'normal', occupied: false, id: 123 },
                    { num: 24, type: 'normal', occupied: false, id: 124 }
                ]
            ]
        }
    ];
}

// Actualizar el selector de pisos dinámicamente
function updateFloorSelector() {
    const floorSelector = document.getElementById('floorSelector');
    if (!floorSelector) return;
    
    floorSelector.innerHTML = '';
    
    garageData.forEach((piso, index) => {
        const option = document.createElement('option');
        option.value = index;
        option.textContent = piso.floor;
        floorSelector.appendChild(option);
    });
    
    console.log('📋 Selector de pisos actualizado con:', garageData.length, 'pisos');
}

function changeFloor() {
    currentFloor = parseInt(document.getElementById('floorSelector').value);
    console.log('🔁 Cambiando al piso:', currentFloor);
    renderGarage();
}

function changeDate() {
    selectedDate = document.getElementById('dateSelector').value;
    console.log('📅 Fecha seleccionada:', selectedDate);
}

function toggleTimeSelector() {
    const durationSelector = document.getElementById("durationSelector");
    const timeGroup = document.getElementById("timeGroup");

    const selectedValue = durationSelector.value;
    if (selectedValue.endsWith("h")) {
        timeGroup.style.display = "flex";
    } else {
        timeGroup.style.display = "none";
    }
    updateSummary();
}

function renderGarage() {
    const layout = document.getElementById('garageLayout');
    if (!layout) return;
    
    layout.innerHTML = '';

    if (!garageData || garageData.length === 0) {
        layout.innerHTML = '<div class="error">No hay datos del garage disponibles</div>';
        return;
    }

    const floor = garageData[currentFloor];
    console.log('🎨 Renderizando piso:', floor.floor);

    const floorDiv = document.createElement('div');
    floorDiv.className = 'floor';

    if (currentFloor === 0) {
        const entrance = document.createElement('div');
        entrance.className = 'entrance';
        entrance.innerHTML = '⬇ ENTRADA PRINCIPAL ⬇';
        floorDiv.appendChild(entrance);
    }

    const title = document.createElement('div');
    title.className = 'floor-title';
    title.textContent = floor.floor;
    floorDiv.appendChild(title);

    floor.rows.forEach((row, rowIndex) => {
        const rowDiv = document.createElement('div');
        rowDiv.className = 'spaces-row';

        row.forEach(space => {
            const spaceDiv = document.createElement('div');
            spaceDiv.className = `space ${space.type}`;
            
            if (space.occupied) {
                spaceDiv.classList.add('occupied');
            }

            if (selectedSpaces.find(s => s.num === space.num)) {
                spaceDiv.classList.add('selected');
            }

            const typeLabel = {
                normal: 'Standard',
                premium: 'Premium',
                moto: 'Moto'
            };

            spaceDiv.innerHTML = `
                <span class="space-number">${space.num}</span>
                <span class="space-type">${typeLabel[space.type]}</span>
            `;

            if (!space.occupied) {
                spaceDiv.onclick = () => toggleSpace(space.num, space.type, space.id);
            }

            rowDiv.appendChild(spaceDiv);
        });

        floorDiv.appendChild(rowDiv);
    });

    layout.appendChild(floorDiv);
    console.log('✅ Garage renderizado correctamente');
}

function toggleSpace(num, type, id) {
    const index = selectedSpaces.findIndex(s => s.num === num);
    
    if (index > -1) {
        selectedSpaces.splice(index, 1);
        console.log('❌ Espacio deseleccionado:', num);
    } else {
        const spaceInfo = {
            num: num,
            type: type,
            id: id,
            floor: currentFloor,
            floorName: garageData[currentFloor].floor,
            price: calculatePrice(type)
        };
        selectedSpaces.push(spaceInfo);
        console.log('✅ Espacio seleccionado:', spaceInfo);
    }

    updateSummary();
    renderGarage();
}

function calculatePrice(type) {
    const durationSelector = document.getElementById("durationSelector");
    const selectedValue = durationSelector.value;
    
    if (selectedValue.endsWith("h")) {
        switch (selectedValue) {
            case "1h": 
                switch(type) {
                    case 'normal': return 5;
                    case 'premium': return 10;
                    case 'moto': return 3;
                }
            case "6h": 
                switch(type) {
                    case 'normal': return 20;
                    case 'premium': return 40;
                    case 'moto': return 12;
                }
            case "12h": 
                switch(type) {
                    case 'normal': return 35;
                    case 'premium': return 70;
                    case 'moto': return 20;
                }
        }
    }
    
    const monthlyPrices = {
        normal: 1200,
        premium: 2500,
        moto: 800
    };
    
    const months = parseInt(selectedValue);
    return monthlyPrices[type] * months;
}

function updateSummary() {
    const durationSelector = document.getElementById("durationSelector");
    const durationDisplay = document.getElementById("durationDisplay");
    const totalPrice = document.getElementById("totalPrice");
    const selectedCount = document.getElementById("selectedCount");
    const reserveBtn = document.getElementById("reserveBtn");
    
    const selectedValue = durationSelector.value;
    let displayText = "";
    
    if (selectedValue.endsWith("h")) {
        switch (selectedValue) {
            case "1h": displayText = "1 Hora"; break;
            case "6h": displayText = "6 Horas"; break;
            case "12h": displayText = "12 Horas"; break;
        }
    } else {
        switch (selectedValue) {
            case "1": displayText = "1 Mes"; break;
            case "3": displayText = "3 Meses"; break;
            case "6": displayText = "6 Meses"; break;
            case "12": displayText = "12 Meses"; break;
        }
    }
    
    if (durationDisplay) durationDisplay.textContent = displayText;
    if (selectedCount) selectedCount.textContent = selectedSpaces.length;
    
    const total = selectedSpaces.reduce((sum, space) => sum + space.price, 0);
    if (totalPrice) totalPrice.textContent = `$${total}`;
    
    if (reserveBtn) {
        reserveBtn.disabled = selectedSpaces.length === 0;
    }
    
    console.log('💰 Resumen actualizado:', {
        espacios: selectedSpaces.length,
        total: total,
        duracion: displayText
    });
}

function getDurationText(durationValue) {
    const durations = {
        "1": "1 Mes",
        "3": "3 Meses", 
        "6": "6 Meses",
        "12": "12 Meses",
        "1h": "1 Hora",
        "6h": "6 Horas",
        "12h": "12 Horas"
    };
    return durations[durationValue] || durationValue;
}

function confirmReservation() {
    if (selectedSpaces.length === 0) {
        alert("Por favor selecciona al menos un espacio.");
        return;
    }

    const date = document.getElementById("dateSelector").value;
    const durationSelector = document.getElementById("durationSelector");
    const time = document.getElementById("timeSelector")?.value;
    
    if (!date) {
        alert("Por favor selecciona una fecha para la reserva.");
        return;
    }

    if (durationSelector.value.endsWith("h") && !time) {
        alert("Selecciona una hora de inicio para la reserva por horas.");
        return;
    }

    const reservationData = prepareReservationData(date, durationSelector.value, time);
    showReservationSummary(reservationData);
}

function prepareReservationData(date, durationValue, time) {
    const total = selectedSpaces.reduce((sum, space) => sum + space.price, 0);
    
    return {
        spaces: selectedSpaces.map(space => ({
            number: space.num,
            type: space.type,
            floor: space.floor,
            price: space.price,
            id: space.id
        })),
        date: date,
        duration: durationValue,
        startTime: time,
        total: total,
        currency: "USD",
        reservationDate: new Date().toISOString(),
        status: "pending"
    };
}

function showReservationSummary(reservation) {
    const spaceNumbers = reservation.spaces.map(s => s.number).join(', ');
    const spaceTypes = [...new Set(reservation.spaces.map(s => {
        const types = {
            'normal': 'Standard',
            'premium': 'Premium', 
            'moto': 'Moto'
        };
        return types[s.type];
    }))].join(', ');
    
    let message = `🚗 RESUMEN DE RESERVA 🚗\n\n`;
    message += `📍 Espacios: ${spaceNumbers}\n`;
    message += `🏷️ Tipo: ${spaceTypes}\n`;
    message += `📅 Fecha: ${reservation.date}\n`;
    message += `⏰ Duración: ${getDurationText(reservation.duration)}\n`;
    
    if (reservation.startTime) {
        message += `🕐 Hora inicio: ${reservation.startTime}\n`;
    }
    
    message += `💰 Total: $${reservation.total}\n\n`;
    message += `¿Confirmar reserva?`;

    if (confirm(message)) {
        sendToDatabase(reservation);
    }
}

async function sendToDatabase(reservationData) {
    try {
        const clienteId = obtenerClienteId();
        
        const espaciosIds = reservationData.spaces.map(space => space.id);
        
        const requestData = {
            espaciosIds: espaciosIds,
            fechaInicio: reservationData.date,
            duracion: reservationData.duration,
            horaInicio: reservationData.startTime || null
        };

        console.log('📤 Enviando reserva al backend:', requestData);

        const response = await fetch('http://localhost:8081/api/reservas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-User-Id': clienteId.toString()
            },
            body: JSON.stringify(requestData)
        });

        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }

        const data = await response.json();
        console.log('✅ Respuesta del backend:', data);
        
        if (data.success) {
            alert(`✅ RESERVA CONFIRMADA\n\nEspacios: ${reservationData.spaces.map(s => s.number).join(', ')}\nDuración: ${getDurationText(reservationData.duration)}\nTotal: $${data.total}\n\n${data.mensaje}`);
            loadGarageData();
            clearSelection();
        } else {
            alert(`❌ ERROR\n\n${data.mensaje}`);
        }
    } catch (error) {
        console.error('Error completo:', error);
        if (error.message.includes('autenticado')) {
            return;
        }
        
        // Simular éxito en modo desarrollo
        if (error.message.includes('Failed to fetch')) {
            alert(`✅ RESERVA SIMULADA (Modo desarrollo)\n\nEspacios: ${reservationData.spaces.map(s => s.number).join(', ')}\nDuración: ${getDurationText(reservationData.duration)}\nTotal: $${reservationData.total}\n\nEl backend no está disponible, pero la reserva se procesó localmente.`);
            loadGarageData();
            clearSelection();
        } else {
            alert('❌ Error al conectar con el servidor.');
        }
    }
}

function clearSelection() {
    selectedSpaces = [];
    updateSummary();
    renderGarage();
    console.log('🧹 Selección limpiada');
}

function initializePage() {
    const today = new Date().toISOString().split('T')[0];
    const dateSelector = document.getElementById('dateSelector');
    if (dateSelector) {
        dateSelector.value = today;
        dateSelector.min = today;
    }
    selectedDate = today;
    
    toggleTimeSelector();
    verificarAutenticacion();
    loadGarageData();
}

document.addEventListener('DOMContentLoaded', function() {
    initializePage();
});