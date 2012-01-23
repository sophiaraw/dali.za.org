package org.za.dali



import org.junit.*
import grails.test.mixin.*

@TestFor(CompanyController)
@Mock(Company)
class CompanyControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/costCentre/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.costCentreInstanceList.size() == 0
        assert model.costCentreInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.costCentreInstance != null
    }

    void testSave() {
        controller.save()

        assert model.costCentreInstance != null
        assert view == '/costCentre/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/costCentre/show/1'
        assert controller.flash.message != null
        assert Company.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/costCentre/list'


        populateValidParams(params)
        def costCentre = new Company(params)

        assert costCentre.save() != null

        params.id = costCentre.id

        def model = controller.show()

        assert model.costCentreInstance == costCentre
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/costCentre/list'


        populateValidParams(params)
        def costCentre = new Company(params)

        assert costCentre.save() != null

        params.id = costCentre.id

        def model = controller.edit()

        assert model.costCentreInstance == costCentre
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/costCentre/list'

        response.reset()


        populateValidParams(params)
        def costCentre = new Company(params)

        assert costCentre.save() != null

        // test invalid parameters in update
        params.id = costCentre.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/costCentre/edit"
        assert model.costCentreInstance != null

        costCentre.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/costCentre/show/$costCentre.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        costCentre.clearErrors()

        populateValidParams(params)
        params.id = costCentre.id
        params.version = -1
        controller.update()

        assert view == "/costCentre/edit"
        assert model.costCentreInstance != null
        assert model.costCentreInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/costCentre/list'

        response.reset()

        populateValidParams(params)
        def costCentre = new Company(params)

        assert costCentre.save() != null
        assert Company.count() == 1

        params.id = costCentre.id

        controller.delete()

        assert Company.count() == 0
        assert Company.get(costCentre.id) == null
        assert response.redirectedUrl == '/costCentre/list'
    }
}
