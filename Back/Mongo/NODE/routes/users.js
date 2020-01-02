const router = require('express').Router();
const mongojs = require('mongojs')
const db = mongojs('mean-db', ['user'])

// Obtener a los vehiculos
router.get('/users', (req, res, next) => {
    db.user.find((err, users) => {
        if (err) return next(err);
        res.json(users);
    });
});

// Obtener un solo vehiculo
router.get('/user/:id', (req, res, next) => {
    db.user.findOne({ _id: mongojs.ObjectId(req.params.id) }, (err, user) => {
        if (err) return next(err);
        res.json(user);
    });
});

// Añadir vehiculo
router.post('/user', (req, res, next) => {
    const user = req.body;
    console.log(user);
    db.user.save(user, (err, user) => {
        if (err) return next(err);
        res.json(user);
    })
})

// Eliminar vehiculo
router.delete('/user/:id', (req, res, next) => {
    console.log(req.params.id);
    db.user.remove({ _id: mongojs.ObjectId(req.params.id) }, (err, user) => {
        if (err) { res.send(err); }
        res.json(user);
    });
})

// Actualizar vehiculo
router.put('/user/:id', (req, res, next) => {
    const user = req.body;
    console.log(user);
    db.user.update({ _id: mongojs.ObjectId(req.params.id) }, {
        $set: {
            name: user.name,
            email: user.email,
            pwd: user.pwd,
        }
    }, (err, user) => {
        if (err) return next(err);
        res.json(user);
    });
});

module.exports = router;