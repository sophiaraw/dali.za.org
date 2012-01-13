package org.za.dali



import org.junit.*
import grails.test.mixin.*

@TestFor(ContactDetailController)
@Mock(ContactDetail)
class ContactDetailControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/contactDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.contactDetailInstanceList.size() == 0
        assert model.contactDetailInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.contactDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.contactDetailInstance != null
        assert view == '/contactDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/contactDetail/show/1'
        assert controller.flash.message != null
        assert ContactDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/contactDetail/list'


        populateValidParams(params)
        def contactDetail = new ContactDetail(params)

        assert contactDetail.save() != null

        params.id = contactDetail.id

        def model = controller.show()

        assert model.contactDetailInstance == contactDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/contactDetail/list'


        populateValidParams(params)
        def contactDetail = new ContactDetail(params)

        assert contactDetail.save() != null

        params.id = contactDetail.id

        def model = controller.edit()

        assert model.contactDetailInstance == contactDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/contactDetail/list'

        response.reset()


        populateValidParams(params)
        def contactDetail = new ContactDetail(params)

        assert contactDetail.save() != null

        // test invalid parameters in update
        params.id = contactDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/contactDetail/edit"
        assert model.contactDetailInstance != null

        contactDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/contactDetail/show/$contactDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        contactDetail.clearErrors()

        populateValidParams(params)
        params.id = contactDetail.id
        params.version = -1
        controller.update()

        assert view == "/contactDetail/edit"
        assert model.contactDetailInstance != null
        assert model.contactDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/contactDetail/list'

        response.reset()

        populateValidParams(params)
        def contactDetail = new ContactDetail(params)

        assert contactDetail.save() != null
        assert ContactDetail.count() == 1

        params.id = contactDetail.id

        controller.delete()

        assert ContactDetail.count() == 0
        assert ContactDetail.get(contactDetail.id) == null
        assert response.redirectedUrl == '/contactDetail/list'
    }
}
